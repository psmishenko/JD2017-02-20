package by.it.psmishenko.matlab;


public interface IVariable {
    String toString();
    void fromString(String str) throws MathException;

}
