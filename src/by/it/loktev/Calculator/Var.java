package by.it.loktev.Calculator;

import java.io.Serializable;

abstract public class Var extends ExpressionPart implements IOperation, IVariable/*, Serializable*/ {

    @Override
    public Var add(Var arg) throws CalculatorException {
        throw new CalculatorException("операция cложения не реализована для таких типов значений");
    }

    @Override
    public Var mul(Var arg) throws CalculatorException {
        throw new CalculatorException("операция умножения не реализована для таких типов значений");
    }

    @Override
    public Var div(Var arg) throws CalculatorException {
        throw new CalculatorException("операция деления не реализована для таких типов значений");
    }

    @Override
    public Var sub(Var arg) throws CalculatorException {
        throw new CalculatorException("операция вычитания не реализована для таких типов значений");
    }

    @Override
    PartType getPartType() {
        return PartType.partVar;
    }

    @Override
    boolean isSubExprStart() {
        return false;
    }

    @Override
    boolean isSubExprEnd() {
        return true;
    }

    @Override
    public String serialize() {
        return toString();
    }

    @Override
    public void unserialize(String s) throws CalculatorException {
            fromString(s);
    }

}
