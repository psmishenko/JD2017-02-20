package by.it.zeynalov.jd01_09_matlab_homework;


public abstract class Var implements Operation, Variable {
    @Override
    public Var add(Var var) throws MathException {
        throw new MathException("Операция сложения невозможна");
    }

    @Override
    public Var mul(Var var) throws MathException {
        throw new MathException("Операция вычитания невозможна");
    }

    @Override
    public Var div(Var var) throws MathException {
        throw new MathException("Операция умножения невозможна");
    }

    @Override
    public Var sub(Var var) throws MathException {
        throw new MathException("Операция деления невозможна");
    }
}
