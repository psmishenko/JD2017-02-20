package by.it.prigozhanov.my_matlab;

import by.it.akhmelev.jd01_09_classwork_matlab.VarV;

/**
 * Created by v-omf on 4/11/2017.
 *
 * @author v-omf
 */
public class VarValue extends Var {
    private Double value;


    public VarValue(String string) {
        fromString(string);
    }

    public VarValue(Double value) {
        this.value = value;
    }

    public VarValue(VarValue value) {
        this.value = value.value;
    }

    @Override
    public Var plus(Var var) {
        if (var instanceof VarValue) {
            VarValue operand = (VarValue) var;
            return new VarValue(this.value+operand.value);
        } else
            return super.minus(var);
    }

    @Override
    public Var minus(Var var) {
        if (var instanceof VarValue) {
            VarValue operand = (VarValue) var;
            return new VarValue(this.value-operand.value);
        } else
        return super.minus(var);
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarValue) {
            VarValue operand = (VarValue) var;
            return new VarValue(this.value/operand.value);
        } else
        return super.div(var);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarValue) {
            VarValue operand = (VarValue) var;
            return new VarValue(this.value*operand.value);
        } else
        return super.mul(var);
    }


    @Override
    public String toString() {
        return this.value.toString();
    }

    @Override
    public void fromString(String stringValue) {
        this.value = Double.parseDouble(stringValue);
    }
}
