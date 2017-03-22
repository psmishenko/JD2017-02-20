package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarF extends Var {

    static public String doubleRE=" *\\-?\\d+(?:\\.\\d*)? *";
    static Pattern p = Pattern.compile("^"+doubleRE+"$");

    public double value;

    static Boolean canFromString(String str){
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public VarF(String str) throws CalculatorException {
        fromString(str);
    }

    public VarF(double value) {
        this.value = value;
    }

    public VarF(VarF v) {
        this.value = v.value;
    }

    @Override
    public void fromString(String str) throws CalculatorException {
        Matcher m = p.matcher(str);
        if ( !m.matches() ) {
            throw new CalculatorException(str + " - недопустимое значение для преобразования в число");
        }
        this.value=Double.parseDouble(m.group());
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    @Override
    public Var add(Var arg) throws CalculatorException {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value+argF.value);
        }
        else
            return arg.add(this);
    }

    public Var sub(Var arg) throws CalculatorException {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value-argF.value);
        }
        return super.sub(arg);
    }

    public Var mul(Var arg) throws CalculatorException {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            return new VarF(this.value*argF.value);
        }
        else
            return arg.mul(this);
    }

    public Var div(Var arg) throws CalculatorException {
        if (arg instanceof VarF)
        {
            VarF argF=(VarF)arg;
            if ( argF.value==0 )
                throw new CalculatorException("VarF.div - деление на ноль!");
            return new VarF(this.value/argF.value);
        }
        return super.div(arg);
    }

    public void neg(){
        value=-value;
    }

}
