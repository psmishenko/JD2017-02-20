package by.it.loktev.Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {

    static public String vectorRE=" *\\{ *(" + VarF.doubleRE + ",)* *" + VarF.doubleRE + "\\} *";

    static Boolean canFromString(String str){
        Pattern p = Pattern.compile("^"+vectorRE+"$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    double [] value;
    int size;

    public VarV(String str) {
        fromString(str);
    }

    @Override
    public void fromString(String str) {

        // ожидаем строку вида {55.2,8,3.3}

        // убираем фигурные скобки
        Pattern p = Pattern.compile("^ *\\{ *([\\-\\+\\d\\., ]*) *\\} *$");
        Matcher m = p.matcher(str);
        if ( !m.matches() ) {
            new CalculatorError(str + " - недопустимое значение для преобразования в вектор");
            return;
        }
        String valuesStr=m.group(1);

        // разбиваем запятыми
        String [] valuesArr=valuesStr.split(" *, *");

        this.size=valuesArr.length;
        this.value=new double[this.size];

        String doubleRE=" *\\d+(?:\\.\\d*)? *";
        p = Pattern.compile("^"+doubleRE+"$");

        for ( int i=0; i<this.size; i++ )
        {
            String valueStr=valuesArr[i];
            m = p.matcher(valueStr);
            if ( !m.matches() ) {
                new CalculatorError(valueStr + " - недопустимое значение для преобразования в число");
                return;
            }
            this.value[i]=Double.parseDouble(m.group());
        }

    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("{");
        for ( int i=0; i<this.size; i++ ) {
            if ( i>0 )
                sb.append(",");
            sb.append(this.value[i]);
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var arg) {
        System.out.println("сложение вектора с чем-то");
        return null;
    }
}
