package by.it.zeynalov.jd02_06.TaskB;

public class VarF extends Var {
    private float value; //передаем VarF какое либо значение в данном случае - float

    public float getValue() {
        return value;
    }

    public VarF(float value) {
        this.value = value;
    }

    public VarF(String value) {
        this.value = Float.parseFloat(value); //Float.parseFloat() - преобразует строку во float
    }

    @Override
    public void fromString(String value) {
        this.value = Float.parseFloat(value);
    }

    @Override
    public String toString() { //здесь мы описываем как объект будет выглядить в виде строки

        return String.valueOf(value);
    }

    @Override
    public Var add(Var var) throws MathException {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            History.getInstance().addMesage("Выполнено: " + this + " + " + operand + " = " +  new VarF(this.value + operand.value));
            return new VarF(this.value + operand.value);
        } else
            return (var.add(this));
    }

    @Override
    public Var mul(Var var) throws MathException {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value - operand.value);
        } else
            return (var.mul(this));
    }

    @Override
    public Var div(Var var) throws MathException {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value * operand.value);
        } else
            return super.div(var);
    }

    @Override
    public Var sub(Var var) throws MathException {
        if (var instanceof VarF) {
            VarF operand = (VarF) var;
            return new VarF(this.value / operand.value);
        } else
            return (var.sub(this));
    }
}

