package by.it.radivonik.calculator;

import static by.it.radivonik.calculator.IOperation.OperationType.*;

/**
 * Created by Radivonik on 18.03.2017.
 */
public class Operation implements IOperation {
    @Override
    public Var add(Var op1, Var op2) {
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
    public Var sub(Var op1, Var op2) {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return sub((VarFloat)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return sub((VarFloat)op1,(VarVector)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return sub((VarVector)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return sub((VarVector)op1,(VarVector)op2);
        }
        else
            return null;
    }

    @Override
    public Var mul(Var op1, Var op2) {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return mul((VarFloat)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return mul((VarFloat)op1,(VarVector)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return add((VarVector)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return mul((VarVector)op1,(VarVector)op2);
        }
        else
            return null;
    }

    @Override
    public Var div(Var op1, Var op2) {
        if (op1 instanceof VarFloat && op2 instanceof VarFloat) {
            return div((VarFloat)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarFloat && op2 instanceof VarVector) {
            return div((VarFloat)op1,(VarVector)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarFloat) {
            return div((VarVector)op1,(VarFloat)op2);
        }
        else if (op1 instanceof VarVector && op2 instanceof VarVector) {
            return div((VarVector)op1,(VarVector)op2);
        }
        else
            return null;
    }

    @Override
    public void save(String name, Var var) {
        Var.vars.put(name,var);
    }

    // Реализация различных операций для операндов разных классов
    private Var oper(VarFloat op1, VarFloat op2, OperationType op) {
        VarFloat res = null;
        switch(op) {
            case Add:
                res = new VarFloat(op1.getValue() + op2.getValue()); break;
            case Sub:
                res = new VarFloat(op1.getValue() - op2.getValue()); break;
            case Mul:
                res = new VarFloat(op1.getValue() * op2.getValue()); break;
            case Div:
                res = new VarFloat(op1.getValue() / op2.getValue()); break;
        }
        return res;
    }

    private Var oper(VarFloat op1, VarVector op2, OperationType op) {
        if (op == Add || op == Mul)
            return oper(op2,op1,op);
        else {
            new Error("Недопустимая операция");
            return null;
        }
    }

    private Var oper(VarVector op1, VarFloat op2, OperationType op) {
        double[] v = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++)
            v[i] = op2.getValue();
        return oper(op1,new VarVector(v),op);
    }

    private Var oper(VarVector op1, VarVector op2, OperationType op) {
        if (!checkVector(op1,op2))
            return null;
        double[] ares = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++) {
            switch(op) {
                case Add:
                    ares[i] = op1.getItem(i) + op2.getItem(i); break;
                case Sub:
                    ares[i] = op1.getItem(i) - op2.getItem(i); break;
                case Mul:
                    ares[i] = op1.getItem(i) * op2.getItem(i); break;
                case Div:
                    ares[i] = op1.getItem(i) / op2.getItem(i); break;
            }
        }
        return new VarVector(ares);
    }

    // Операции вычитания
    private Var sub(VarFloat op1, VarFloat op2) {
        return new VarFloat(op1.getValue() - op2.getValue());
    }

    private Var sub(VarFloat op1, VarVector op2) {
        return sub(op2,op1);
    }

    private Var sub(VarVector op1, VarFloat op2) {
        double[] v2 = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++)
            v2[i] = op2.getValue();
        return sub(op1,new VarVector(v2));
    }

    private Var sub(VarVector op1, VarVector op2) {
        if (!checkVector(op1,op2))
            return null;
        double[] ares = new double[op1.length()];
        for (int i = 0; i < op1.length(); i++) {
            ares[i] = op1.getItem(i) - op2.getItem(i);
        }
        return new VarVector(ares);
    }

    // Операции умножения
    private Var mul(VarFloat op1, VarFloat op2) {
        return new VarFloat(op1.getValue() * op2.getValue());
    }

    // Операции деления
    private Var div(VarFloat op1, VarFloat op2) {
        return new VarFloat(op1.getValue() / op2.getValue());
    }

    // Проверки
    private boolean checkVector(VarVector v1, VarVector v2) {
        if (v1.length() != v2.length()) {
            new Error("У векторов в операции разная длина");
            return false;
        }
        return true;
    }
}
