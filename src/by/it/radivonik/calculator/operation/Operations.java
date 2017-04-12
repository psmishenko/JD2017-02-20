package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.variable.Var;
import by.it.radivonik.calculator.variable.VarFloat;
import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.variable.VarCreator;
import by.it.radivonik.calculator.variable.VarMatrix;
import by.it.radivonik.calculator.variable.VarVector;

import java.util.*;

/**
 * Created by Radivonik on 08.04.2017.
 */
public class Operations {
    private static Map<String,Operation> operations = new HashMap<>();

    static {
        operations.put("(",new Operation("(", IOperation.Type.BracketLeft, 0));
        operations.put(")",new Operation(")", IOperation.Type.BracketRight, 0));
        operations.put("+",new Operation("+", IOperation.Type.TwoArg, 2));
        operations.put("-",new Operation("-", IOperation.Type.TwoArg, 2));
        operations.put("*",new Operation("*", IOperation.Type.TwoArg, 4));
        operations.put("/",new Operation("/", IOperation.Type.TwoArg, 4));
        operations.put("=",new Operation("=", IOperation.Type.TwoArg, 1));
        operations.put("printvar",new Operation("printvar", IOperation.Type.NoArg, 0));
        operations.put("sortvar",new Operation("sortvar", IOperation.Type.NoArg, 0));
    }

    static String calc(IOperation op, String... args) throws MathException, ParseException {
        String res = null;
        switch(op.getType()) {
            case NoArg:
                res = calcNoArg(op); break;
            case TwoArg:
                if (op.getOperator() == "=")
                    res = Var.setVar(args[0],args[1]).toString();
                else
                    res = calcTwoArg(op, VarCreator.getCreator().create(args[0]), VarCreator.getCreator().create(args[1]));
                break;
        }
        return res;
    }

    public static Operation getOperation(String operator) {
       return operations.get(operator);
    }

    public static String getPattern() {
        StringBuilder patternBracket = new StringBuilder("");
        StringBuilder patternNoArg = new StringBuilder("");
        StringBuilder patternTwoArg = new StringBuilder("");
        for (Operation op: operations.values()) {
            if ( op.getType() == IOperation.Type.BracketLeft || op.getType() == IOperation.Type.BracketRight) {
                patternBracket.append(op.getOperator());
            }
            if ( op.getType() == IOperation.Type.NoArg) {
                patternNoArg.append("|").append(op.getOperator());
            }
            else if ( op.getType() == IOperation.Type.TwoArg) {
                if (op.getOperator() == "-")
                    patternTwoArg.append("\\");
                patternTwoArg.append(op.getOperator());
            }
        }
        return "(?<=[^{," + patternTwoArg + "])([" + patternTwoArg + "])|[" + patternBracket + "]" + patternNoArg;
    }

    private static String calcNoArg(IOperation op) {
        String res = null;
        switch (op.getOperator()) {
            case "printvar":
                res = Var.getPrintVar(); break;
            case "sortvar":
                res = Var.getSortVar(); break;
        }
        return res;
    }

    private static String getOp(IOperation op, Var v1, Var v2) {
        return v1.toString() + op.getOperator() + v2.toString();
    }

    private static String calcTwoArg(IOperation op, Var v1, Var v2) throws MathException, ParseException {
        if (v1 instanceof VarFloat && v2 instanceof VarFloat) {
            return calcTwoArg(op, (VarFloat)v1, (VarFloat)v2);
        }
        else if (v1 instanceof VarFloat && v2 instanceof VarVector) {
            return calcTwoArg(op, (VarFloat)v1,(VarVector)v2);
        }
        else if (v1 instanceof VarFloat && v2 instanceof VarMatrix) {
            return calcTwoArg(op, (VarFloat)v1, (VarMatrix)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarFloat) {
            return calcTwoArg(op, (VarVector)v1,(VarFloat)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarVector) {
            return calcTwoArg(op, (VarVector)v1,(VarVector)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarMatrix) {
            return calcTwoArg(op, (VarVector)v1,(VarMatrix)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarFloat) {
            return calcTwoArg(op, (VarMatrix)v1,(VarFloat)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarVector) {
            return calcTwoArg(op, (VarMatrix)v1,(VarVector)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarMatrix) {
            return calcTwoArg(op, (VarMatrix)v1,(VarMatrix)v2);
        }
        else
            return null;
    }

    private static String calcTwoArg(IOperation op, VarFloat v1, VarFloat v2) throws MathException {
        Var res = null;
        switch (op.getOperator()) {
            case "+":
                res = new VarFloat(v1.getValue() + v2.getValue()); break;
            case "-":
                res = new VarFloat(v1.getValue() - v2.getValue()); break;
            case "*":
                res = new VarFloat(v1.getValue() * v2.getValue()); break;
            case "/":
                if (v2.getValue() == 0)
                    throw new MathException("Деление на ноль: " + getOp(op,v1,v2));
                res = new VarFloat(v1.getValue() / v2.getValue()); break;
            default:
                return null;
        }
        return res.toString();
    }

    private static String calcTwoArg(IOperation op, VarFloat v1, VarVector v2) throws MathException {
        if (op.getOperator() == "+" || op.getOperator() == "*")
            return calcTwoArg(op,v2,v1);
        else {
            throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
        }
    }

    private static String calcTwoArg(IOperation op, VarFloat v1, VarMatrix v2) throws MathException, ParseException {
        if (op.getOperator() == "+" || op.getOperator() == "*")
            return calcTwoArg(op,v2,v1);
        else {
            throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
        }
    }

    private static String calcTwoArg(IOperation op, VarVector v1, VarFloat v2) throws MathException {
        double[] v = new double[v1.length()];
        for (int i = 0; i < v1.length(); i++)
            v[i] = v2.getValue();
        return calcTwoArg(op, v1, new VarVector(v));
    }

    private static String calcTwoArg(IOperation op, VarVector v1, VarVector v2) throws MathException {
        if (v1.length() != v2.length()) {
            throw new MathException("У векторов в операции разная длина: " + getOp(op,v1,v2));
        }
        double[] res = new double[v1.length()];
        for (int i = 0; i < v1.length(); i++) {
            switch(op.getOperator()) {
                case "+":
                    res[i] = v1.getItem(i) + v2.getItem(i); break;
                case "-":
                    res[i] = v1.getItem(i) - v2.getItem(i); break;
                case "*":
                    res[i] = v1.getItem(i) * v2.getItem(i); break; // некорректная математическая операция
                case "/":
                    if (v2.getItem(i) == 0)
                        throw new MathException("Деление на ноль: " + getOp(op,v1,v2));
                    res[i] = v1.getItem(i) / v2.getItem(i); break;
                default:
                    return null;
            }
        }
        return new VarVector(res).toString();
    }

    private static String calcTwoArg(IOperation op, VarVector v1, VarMatrix v2) throws MathException {
        throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
    }

    private static String calcTwoArg(IOperation op, VarMatrix v1, VarFloat v2) throws MathException, ParseException {
        double[][] m = new double[v1.rowCount()][v1.colCount()];
        for (int i = 0; i < v1.rowCount(); i++) {
            for (int j = 0; j < v1.colCount(); j++)
                m[i][j] = v2.getValue();
        }
        return calcTwoArg(op, v1, new VarMatrix(m));
    }

    private static String calcTwoArg(IOperation op, VarMatrix v1, VarVector v2) throws MathException {
        return null;
    }

    private static String calcTwoArg(IOperation op, VarMatrix v1, VarMatrix v2) throws MathException, ParseException {
        if (v1.rowCount() != v2.rowCount() || v1.colCount() != v2.colCount()) {
            throw new MathException("У матриц в операции разная размерность: " + getOp(op,v1,v2));
        }
        double[][] res = new double[v1.rowCount()][v1.colCount()];
        for (int i = 0; i < v1.rowCount(); i++) {
            for (int j = 0; j < v1.colCount() ; j++) {
                switch(op.getOperator()) {
                    case "+":
                        res[i][j] = v1.getItem(i,j) + v2.getItem(i,j);
                        break;
                    case "-":
                        res[i][j] = v1.getItem(i,j) - v2.getItem(i,j);
                        break;
                    case "*":
                        res[i][j] = v1.getItem(i,j) * v2.getItem(i,j);
                        break; // некорректная математическая операция
                    case "/":
                        if (v2.getItem(i,j) == 0)
                            throw new MathException("Деление на ноль: " + getOp(op, v1, v2));
                        res[i][j] = v1.getItem(i,j) / v2.getItem(i,j);
                        break;
                    default:
                        return null;
                }
            }
        }
        return new VarMatrix(res).toString();
   }
}
