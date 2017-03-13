package by.it.loktev.Calculator;

public class VarF extends Var {

    private Double value;

    @Override
    public Var add(Var arg) {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value+argF.value);
        }
        else
            return arg.add(this);
    }

    public Var sub(Var arg) {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value-argF.value);
        }
        return super.sub(arg);
    }

    public Var mul(Var arg) {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value*argF.value);
        }
        else
            return arg.mul(this);
    }

    public Var div(Var arg) {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value/argF.value);
        }
        return super.div(arg);
    }

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

    @Override
    public String toString() {
        return value.toString();
    }
}
