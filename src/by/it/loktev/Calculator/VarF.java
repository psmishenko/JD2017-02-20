package by.it.loktev.Calculator;

public class VarF extends Var {

    private double value;

    public VarF(String str) {
        fromString(str);
    }

    public VarF(double value) {
        this.value = value;
    }

    public VarF(VarF v) {
        this.value = v.value;
    }

    @Override
    public void fromString(String str) {
        this.value=Double.parseDouble(str);
    }
}
