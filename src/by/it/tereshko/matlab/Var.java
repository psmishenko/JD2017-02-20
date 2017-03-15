package by.it.tereshko.matlab;

public abstract class Var implements IOperation, IVariable {
    @Override
    public Var add(Var var) {
        new Error("Addition operation impossible");
        return null;
    }

    @Override
    public Var sub(Var var) {
        new Error("Subtraction operation impossible");
        return null;
    }

    @Override
    public Var mul(Var var) {
        new Error("Multiplication operation impossible");
        return null;
    }

    @Override
    public Var div(Var var) {
        new Error("Division operation impossible");
        return null;
    }
}
