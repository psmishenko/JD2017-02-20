package by.it.korzun.matlab;

public abstract class Var implements IOperation, IVariable {
    @Override
    public Var add(Var var) {
        new Error("Операция сложения невозможна");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Операция разности невозможна");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Операция умножения невозможна");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Операция деления невозможна");
        return null;
    }
}
