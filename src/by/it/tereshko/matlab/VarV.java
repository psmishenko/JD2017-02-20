package by.it.tereshko.matlab;

public class VarV extends Var {
    @Override
    public void fromString(String value) {

    }

    @Override
    public Var add(Var var) {
        System.out.println("Caught addition of vector with something");
        return null;
    }
}
