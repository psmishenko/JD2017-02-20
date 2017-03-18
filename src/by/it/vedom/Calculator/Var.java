package by.it.vedom.Calculator;

public abstract class Var implements IOperation, IVariable {

    @Override
    public Var div(Var arg) {
        new Error("Операция деления невозможна");
        return null;
    }

    @Override
    public Var mul(Var arg) {
        new Error("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var sub(Var arg) {
        new Error("Операция вычитания невозможна");
        return null;
    }

    @Override
    public Var add(Var arg) {
        new Error("Операция сложения невозможна");
        return null;
    }
}
