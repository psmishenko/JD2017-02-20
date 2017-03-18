package by.it.ikavalenka.jd_11.Math_Lab;

/**
 * Created by USER on 13.03.2017.
 */
public class VarF extends Var{
    public Double value;    // double  change to Double

    @Override
    public Var add(Var var) {
        Var result = null;
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            //result = new VarF(this.value + operand.value);
            return new VarF(this.value + operand.value);
        } else
            return (var.add(this));

    }

    public Var sub(Var var) {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value - operand.value);
            //return new VarF(this.value - operand.value);
        } else
            return super.sub(var);
    }
    public Var mul(Var var) {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value * operand.value);
            //return new VarF(this.value * operand.value);
        } else
            return super.mul(this);
    }

    public Var div(Var var) {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value / operand.value);
            //return new VarF(this.value / operand.value);
        } else
            return super.div(var);
    }

    public VarF(String value) {
        fromString(value);
    }

    public VarF(double value) {
        this.value = value;
    }


    public VarF(VarF var){
        this.value = value;
    }

    @Override
    public void fromString(String value) {
        this.value = Double.parseDouble(value);
    }
    public String toString(){
        return value.toString();
    }
}
