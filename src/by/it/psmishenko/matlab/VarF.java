package by.it.psmishenko.matlab;


public class VarF extends Var {
    public Double value;

    @Override
    public Var add(Var var) throws MathException {
        if (var instanceof VarF){
            VarF operand = (VarF) var;
            return  new VarF(this.value+operand.value);
        } else return (var.add(this));
    }


    @Override
    public Var sub(Var var) throws MathException {
        if (var instanceof VarF){
            VarF operand = (VarF) var;
            return  new VarF(this.value - operand.value);
        } else return super.sub(var);
    }

    @Override
    public Var mul(Var var) throws MathException {
        if (var instanceof VarF){
            VarF operand = (VarF) var;
            return  new VarF(this.value * operand.value);
        } else return var.mul(this);
    }

    @Override
    public Var div(Var var) throws MathException {
        if (var instanceof VarF){
            VarF operand = (VarF) var;
            if(operand.value==0) throw new MathException("Деление на ноль");
            return  new VarF(this.value / operand.value);
        } else return super.div(var);
    }







    public VarF(String value) {
        fromString(value);
    }
    public VarF(double value) {
       this.value = value;
    }
    @Override
    public void fromString(String str) {
        this.value = Double.parseDouble(str);
    }

    @Override
    public String toString() {
        return  value.toString();
    }

}
