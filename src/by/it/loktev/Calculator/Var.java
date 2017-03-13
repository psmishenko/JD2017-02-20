package by.it.loktev.Calculator;

abstract public class Var implements IOperation, IVariable {

    @Override
    public Var add(Var arg) {
        throw new Error("операция cложения невозможна");
    }

    @Override
    public Var mul(Var arg) {
        throw new Error("операция умножения невозможна");
    }

    @Override
    public Var div(Var arg) {
        throw new Error("операция деления невозможна");
    }

    @Override
    public Var sub(Var arg) {
        throw new Error("операция вычитания невозможна");
    }
}
