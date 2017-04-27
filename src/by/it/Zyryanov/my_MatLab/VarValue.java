package by.it.Zyryanov.my_MatLab;


public class VarValue extends Var {

    public Double value;




    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public void fromString(String var) {
        this.value = Double.parseDouble(var);
    }



    @Override
    public Var add(Var var) {
        VarValue operand;
        if (var instanceof VarValue){
            operand = (VarValue)var;
            return new VarValue(this.value + operand.value);
        } else
        return var.add(this);
    }

    @Override
    public Var sub(Var var) {
        VarValue operand;
        if (var instanceof VarValue){
            operand = (VarValue)var;
            return new VarValue(this.value - operand.value);
        } else
            return var.sub(this);
    }

    @Override
    public Var mul(Var var) {
        VarValue operand;
        if (var instanceof VarValue){
            operand = (VarValue)var;
            return new VarValue(this.value * operand.value);
        } else
            return var.mul(this);
    }

    @Override
    public Var div(Var var) {

        VarValue operand;
        if (var instanceof VarValue){
            operand = (VarValue)var;
            return new VarValue(this.value / operand.value);
        } else
        return var.div(this);
    }


    public VarValue(double value){
        this.value = value;
    }

    public VarValue(String var){
        fromString(var);
    }

    public VarValue(VarValue var) {
        this.value = var.value;
    }


}
