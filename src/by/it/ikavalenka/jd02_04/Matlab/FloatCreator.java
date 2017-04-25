package by.it.ikavalenka.jd02_04.Matlab;


public class FloatCreator extends Creator {

    @Override
    public Var create(String s, int lineQuantity) {
        return new FloatVar(Float.parseFloat(s));
    }
}
