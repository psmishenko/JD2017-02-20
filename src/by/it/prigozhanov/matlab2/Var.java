package by.it.prigozhanov.matlab2;

public abstract class Var implements IOperation, IVariable {
    @Override
    public Var add(Var var) throws MathExeption {
        throw new MathExeption("Операция сложения невозможна");
    }

    @Override
    public Var sub(Var var) throws MathExeption {
        throw new MathExeption("Операция вычитания невозможна");
    }

    @Override
    public Var mul(Var var) throws MathExeption {
        throw new MathExeption("Операция умножения невозможна");
    }

    @Override
    public Var div(Var var) throws MathExeption {
        throw new MathExeption("Операция деления невозможна");
    }
}
