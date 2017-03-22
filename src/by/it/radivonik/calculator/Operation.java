package by.it.radivonik.calculator;

import static by.it.radivonik.calculator.IOperation.OperationType.*;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Operation implements IOperation {
    @Override
    public Var add(Var op1, Var op2) throws MathException {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return oper((VarFloat)op1,(VarFloat)op2, Add);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return oper((VarFloat)op1,(VarVector)op2, Add);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return oper((VarVector)op1,(VarFloat)op2, Add);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return oper((VarVector)op1,(VarVector)op2, Add);
        }
        else
            return null;
    }

    @Override
    public Var sub(Var op1, Var op2) throws MathException {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return oper((VarFloat)op1,(VarFloat)op2, Sub);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return oper((VarFloat)op1,(VarVector)op2, Sub);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return oper((VarVector)op1,(VarFloat)op2, Sub);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return oper((VarVector)op1,(VarVector)op2, Sub);
        }
        else
            return null;
    }

    @Override
    public Var mul(Var op1, Var op2) throws MathException {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return oper((VarFloat)op1,(VarFloat)op2, Mul);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return oper((VarFloat)op1,(VarVector)op2, Mul);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return oper((VarVector)op1,(VarFloat)op2, Mul);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return oper((VarVector)op1,(VarVector)op2, Mul);
        }
        else
            return null;
    }

    @Override
    public Var div(Var op1, Var op2) throws MathException {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return oper((VarFloat)op1,(VarFloat)op2, Div);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return oper((VarFloat)op1,(VarVector)op2, Div);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return oper((VarVector)op1,(VarFloat)op2, Div);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return oper((VarVector)op1,(VarVector)op2, Div);
        }
        else
            return null;
    }

    @Override
    public void save(String name, Var var) throws MathException {
        Var.vars.put(name,var);
    }

    // Реализация различных операций для операндов разных классов
    private Var oper(VarFloat op1, VarFloat op2, OperationType op) throws MathException {
        VarFloat res = null;
        switch(op) {
            case Add:
                res = new VarFloat(op1.getValue() + op2.getValue()); break;
            case Sub:
                res = new VarFloat(op1.getValue() - op2.getValue()); break;
            case Mul:
                res = new VarFloat(op1.getValue() * op2.getValue()); break;
            case Div:
                if (op2.getValue() == 0)
                    throw new MathException("Деление на ноль");
                res = new VarFloat(op1.getValue() / op2.getValue()); break;
        }
        return res;
    }

    private Var oper(VarFloat op1, VarVector op2, OperationType op) throws MathException {
        if (op == Add || op == Mul)
            return oper(op2,op1,op);
        else {
            new MathException("Недопустимая операция");
            return null;
        }
    }

    private Var oper(VarVector op1, VarFloat op2, OperationType op) throws MathException {
        double[] v = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++)
            v[i] = op2.getValue();
        return oper(op1,new VarVector(v),op);
    }

    private Var oper(VarVector op1, VarVector op2, OperationType op) throws MathException {
        if (op1.length() != op2.length()) {
            throw new MathException("У векторов в операции разная длина");
        }
        double[] ares = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++) {
            switch(op) {
                case Add:
                    ares[i] = op1.getItem(i) + op2.getItem(i); break;
                case Sub:
                    ares[i] = op1.getItem(i) - op2.getItem(i); break;
                case Mul:
                    ares[i] = op1.getItem(i) * op2.getItem(i); break; // некорректная математическая операция
                case Div:
                    if (op2.getItem(i) == 0)
                        throw new MathException("Деление на ноль");
                    ares[i] = op1.getItem(i) / op2.getItem(i); break;
            }
        }
        return new VarVector(ares);
    }
}
