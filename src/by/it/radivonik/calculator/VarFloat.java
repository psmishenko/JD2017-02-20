package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class VarFloat extends Var {
    public Double value;

    @Override
    public Var add(Var var) {
        if (var instanceof VarFloat) {
            VarFloat operand = (VarFloat) var;
            return new VarFloat(this.value + operand.value);
        }
        else {
            return var.add(this);
        }
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarFloat) {
            VarFloat operand = (VarFloat) var;
            return new VarFloat(this.value - operand.value);
        }
        else {
            return super.sub(var);
        }
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarFloat) {
            VarFloat operand = (VarFloat) var;
            return new VarFloat(this.value * operand.value);
        }
        else {
            return var.mul(this);
        }
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarFloat) {
            VarFloat operand = (VarFloat) var;
            return new VarFloat(this.value / operand.value);
        }
        else {
            return super.div(var);
        }
    }

    public VarFloat(VarFloat var) {
        this.value = var.value;
    }

    public VarFloat(String value) {
        fromString(value);
    }

    public VarFloat(double value) {
        this.value = value;
    }

    @Override
    public void fromString(String value) {
        this.value = Double.parseDouble(value);
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
