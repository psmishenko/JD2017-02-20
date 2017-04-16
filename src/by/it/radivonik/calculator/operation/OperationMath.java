package by.it.radivonik.calculator.operation;

import by.it.radivonik.calculator.exception.MathException;
import by.it.radivonik.calculator.exception.ParseException;
import by.it.radivonik.calculator.log.Log;
import by.it.radivonik.calculator.variable.*;

import java.util.Deque;

/**
 * Created by Radivonik on 13.04.2017.
 */
public class OperationMath implements IOperationExecute  {
    private static OperationMath operation = new OperationMath();

    public static OperationMath getOperation() {
        return operation;
    }

    @Override
    public String executeOperation(IOperation op, Deque<String> varQueue) throws MathException, ParseException {
        String v2 = varQueue.removeLast();
        String v1 = varQueue.removeLast();
        String res = calc(op, VarCreator.getCreator().create(v1), VarCreator.getCreator().create(v2));
        Log.getLog().write(v1 + " " + op.getOperator() + " " + v2 + " = " + res);
        return res;
    }

    private String calc(IOperation op, Var v1, Var v2) throws MathException, ParseException {
        if (v1 instanceof VarFloat && v2 instanceof VarFloat) {
            return calc(op, (VarFloat)v1, (VarFloat)v2);
        }
        else if (v1 instanceof VarFloat && v2 instanceof VarVector) {
            return calc(op, (VarFloat)v1, (VarVector)v2);
        }
        else if (v1 instanceof VarFloat && v2 instanceof VarMatrix) {
            return calc(op, (VarFloat)v1, (VarMatrix)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarFloat) {
            return calc(op, (VarVector)v1, (VarFloat)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarVector) {
            return calc(op, (VarVector)v1, (VarVector)v2);
        }
        else if (v1 instanceof VarVector && v2 instanceof VarMatrix) {
            return calc(op, (VarVector)v1, (VarMatrix)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarFloat) {
            return calc(op, (VarMatrix)v1, (VarFloat)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarVector) {
            return calc(op, (VarMatrix)v1,(VarVector)v2);
        }
        else if (v1 instanceof VarMatrix && v2 instanceof VarMatrix) {
            return calc(op, (VarMatrix)v1, (VarMatrix)v2);
        }
        else
            return null;
    }

    private String calc(IOperation op, VarFloat v1, VarFloat v2) throws MathException {
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
        }
        return res.toString();
    }

    private String calc(IOperation op, VarFloat v1, VarVector v2) throws MathException {
        if (op.getOperator() == "+" || op.getOperator() == "*")
            return calc(op,v2,v1);
        else {
            throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
        }
    }

    private String calc(IOperation op, VarFloat v1, VarMatrix v2) throws MathException, ParseException {
        if (op.getOperator() == "+" || op.getOperator() == "*")
            return calc(op,v2,v1);
        else {
            throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
        }
    }

    private String calc(IOperation op, VarVector v1, VarFloat v2) throws MathException {
        double[] res = new double[v1.length()];
        for (int i = 0; i < v1.length(); i++) {
            switch (op.getOperator()) {
                case "+":
                    res[i] = v1.getItem(i) + v2.getValue();
                    break;
                case "-":
                    res[i] = v1.getItem(i) - v2.getValue();
                    break;
                case "*":
                    res[i] = v1.getItem(i) * v2.getValue();
                    break;
                case "/":
                    if (v2.getValue() == 0)
                        throw new MathException("Деление на ноль: " + getOp(op, v1, v2));
                    res[i] = v1.getItem(i) / v2.getValue();
                    break;
            }
        }
        return new VarVector(res).toString();
    }

    private String calc(IOperation op, VarVector v1, VarVector v2) throws MathException {
        if (v1.length() != v2.length()) {
            throw new MathException("У векторов в операции разная длина: " + getOp(op,v1,v2));
        }
        else if (op.getOperator() == "/") {
            throw new MathException("Недопустимая операция: " + getOp(op, v1, v2));
        }

        if (op.getOperator() == "+" || op.getOperator() == "-") {
            double[] res = new double[v1.length()];
            for (int i = 0; i < v1.length(); i++) {
                switch (op.getOperator()) {
                    case "+":
                        res[i] = v1.getItem(i) + v2.getItem(i);
                        break;
                    case "-":
                        res[i] = v1.getItem(i) - v2.getItem(i);
                        break;
                }
            }
            return new VarVector(res).toString();
        }
        else if (op.getOperator() == "*") {
            double res = 0.0;
            for (int i = 0; i < v1.length(); i++)
                res += v1.getItem(i) * v2.getItem(i);
            return new VarFloat(res).toString();
        }

        return null;
    }

    private String calc(IOperation op, VarVector v1, VarMatrix v2) throws MathException {
        throw new MathException("Недопустимая операция: " + getOp(op,v1,v2));
    }

    private String calc(IOperation op, VarMatrix v1, VarFloat v2) throws MathException, ParseException {
        double[][] res = new double[v1.rowCount()][v1.colCount()];
        for (int i = 0; i < v1.rowCount(); i++) {
            for (int j = 0; j < v1.colCount(); j++) {
                switch (op.getOperator()) {
                    case "+":
                        res[i][j] = v1.getItem(i, j) + v2.getValue();
                        break;
                    case "-":
                        res[i][j] = v1.getItem(i, j) - v2.getValue();
                        break;
                    case "*":
                        res[i][j] = v1.getItem(i, j) * v2.getValue();
                        break;
                    case "/":
                        if (v2.getValue() == 0)
                            throw new MathException("Деление на ноль: " + getOp(op, v1, v2));
                        res[i][j] = v1.getItem(i, j) / v2.getValue();
                        break;
                }
            }
        }
        return new VarMatrix(res).toString();
    }

    private String calc(IOperation op, VarMatrix v1, VarVector v2) throws MathException {
        if (op.getOperator() == "+" || op.getOperator() == "-" || op.getOperator() == "/") {
            throw new MathException("Недопустимая операция: " + getOp(op, v1, v2));
        }
        else if (v1.colCount() != v2.length()) {
            throw new MathException("Для умножения необходимо чтобы кол-во столбцов матрицы было равно длине вектора: " + getOp(op,v1,v2));
        }

        if (op.getOperator() == "*" ) {
            double[] res = new double[v1.rowCount()];
            for (int i = 0; i < v1.rowCount(); i++) {
                res[i] = 0.0;
                for (int j = 0; j < v1.colCount(); j++)
                    res[i] += v1.getItem(i,j) * v2.getItem(j);
            }
            return new VarVector(res).toString();
        }

        return  null;
    }

    private String calc(IOperation op, VarMatrix v1, VarMatrix v2) throws MathException, ParseException {
        if ((op.getOperator() == "+" || op.getOperator() == "-") &&
            (v1.rowCount() != v2.rowCount() || v1.colCount() != v2.colCount())) {
            throw new MathException("У матриц в операции разная размерность: " + getOp(op,v1,v2));
        }
        if ((op.getOperator() == "*") && (v1.colCount() != v2.rowCount())) {
            throw new MathException("Для умножения необходимо чтобы кол-во столбцов первой матрицы было равно кол-ву строк второй матрицы: " + getOp(op,v1,v2));
        }
        else if (op.getOperator() == "/") {
            throw new MathException("Недопустимая операция: " + getOp(op, v1, v2));
        }

        if (op.getOperator() == "+" || op.getOperator() == "-") {
            double[][] res = new double[v1.rowCount()][v1.colCount()];
            for (int i = 0; i < v1.rowCount(); i++) {
                for (int j = 0; j < v1.colCount() ; j++) {
                    switch(op.getOperator()) {
                        case "+":
                            res[i][j] = v1.getItem(i, j) + v2.getItem(i, j);
                            break;
                        case "-":
                            res[i][j] = v1.getItem(i, j) - v2.getItem(i, j);
                            break;
                    }
                }
            }
            return new VarMatrix(res).toString();
        }
        else if (op.getOperator() == "*") {
            double[][] res = new double[v1.rowCount()][v2.colCount()];
            for (int i = 0; i < v1.rowCount(); i++)
                for (int j = 0; j < v2.colCount(); j++) {
                    res[i][j] = 0.0;
                    for (int k = 0; k < v2.rowCount(); k++)
                        res[i][j] += v1.getItem(i,k) * v2.getItem(k,j);
                }
            return new VarMatrix(res).toString();
        }

        return null;
    }

    private String getOp(IOperation op, Var v1, Var v2) {
        return v1.toString() + op.getOperator() + v2.toString();
    }
}
