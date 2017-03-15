package by.it.loktev.Calculator;

abstract public class Var implements IOperation, IVariable {

    @Override
    public Var add(Var arg) {
        new CalculatorError("операция cложения не реализована для таких типов значений");
        return null;
    }

    @Override
    public Var mul(Var arg) {
        new CalculatorError("операция умножения не реализована для таких типов значений");
        return null;
    }

    @Override
    public Var div(Var arg) {
        new CalculatorError("операция деления не реализована для таких типов значений");
        return null;
    }

    @Override
    public Var sub(Var arg) {
        new CalculatorError("операция вычитания не реализована для таких типов значений");
        return null;
    }
}
