package by.it.loktev.Calculator;

abstract public class Var implements IOperation, IVariable {

    @Override
    public Var add(Var arg) {
        new CalculatorError("операция cложения невозможна");
        return null;
    }

    @Override
    public Var mul(Var arg) {
        new CalculatorError("операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var arg) {
        new CalculatorError("операция деления невозможна");
        return null;
    }

    @Override
    public Var sub(Var arg) {
        new CalculatorError("операция вычитания невозможна");
        return null;
    }
}
