package by.it.smirnov.jd01_09.Vars;

import java.util.Locale;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public class VarF extends Var {
    public Double value;

    public VarF(String value) {
        setFrom(value);
    }
    public VarF(double value) {
        this.value = value;
    }
    public VarF(VarF value) {
        this.value = value.value;

    }


    @Override
    public Var add(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value+((VarF) var).value);
        }
        else
            return (var.add(this));
        //return super.add(var);
    }

    @Override
    public Var sub(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value-((VarF) var).value);
        }
        else
            return super.sub(var);

    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value*((VarF) var).value);
        }
        else
            return (var.mul(this));
    }

    @Override
    public Var div(Var var) {
        if (var instanceof VarF) {
            return new VarF(this.value/((VarF) var).value);
        }
        else
            return super.div(var);
    }

    @Override
    public void setFrom(String x) {
        this.value=Double.parseDouble(x);
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%.2f",value);
        //value.toString();
    }
}
