package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarF extends Var {

    static public String doubleRE=" *\\d+(?:\\.\\d*)? *";
    static Pattern p = Pattern.compile("^"+doubleRE+"$");

    private Double value;

    static Boolean canFromString(String str){
        Matcher m = p.matcher(str);
        return m.matches();
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
        Matcher m = p.matcher(str);
        if ( !m.matches() ) {
            new CalculatorError(str + " - недопустимое значение для преобразования в число");
            return;
        }
        this.value=Double.parseDouble(m.group());
    }

    @Override
    public String toString() {
        return value.toString();
    }

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

}
