package by.it.vedom.jd01_09;

public class VarF extends Var {
    private Double value;

    public VarF(String value) {
        fromString(value);
    }

    public VarF(double value) {
        this.value = value;
    }

    public VarF(VarF var) {
        this.value = var.value;
    }

    @Override
    public void fromString(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public Var add(Var var) {
        if(var instanceof VarF){
            VarF operand = (VarF) var;
            return new VarF(this.value + operand.value);
        } else
        return super.add(this);
    }

    @Override
    public Var sub(Var var) {
        if(var instanceof VarF){
            VarF operand = (VarF) var;
            return new VarF(this.value - operand.value);
        }else
        return super.sub(var);
    }

    @Override
    public Var mul(Var var) {
        if(var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value * operand.value);
        }else
        return super.mul(this);
    }

    @Override
    public Var div(Var var) {
        if(var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value / operand.value);
        }
        return super.div(var);
    }
}
