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

    public VarV(double [] value) {
        this.size=value.length;
        this.value = new double[this.size];
        System.arraycopy(value,0,this.value,0,this.size);
    }

    public VarV(VarV v) {
        this.size=v.size;
        this.value = new double[this.size];
        System.arraycopy(v.value,0,this.value,0,this.size);
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
        if ( arg instanceof VarF ){
            double [] res=new double[this.size];
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]+((VarF)arg).value;
            }
            return new VarV(res);
        }
        if ( arg instanceof VarV ){
            double [] res=new double[this.size];
            VarV argV=(VarV)arg;
            if ( this.size!=argV.size )
            {
                new CalculatorError("операция сложения векторов - разные размеры");
                return null;
            }
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]+argV.value[i];
            }
            return new VarV(res);
        }
        return super.add(arg);
    }

    @Override
    public Var mul(Var arg) {
        if ( arg instanceof VarF ){
            double [] res=new double[this.size];
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]*((VarF)arg).value;
            }
            return new VarV(res);
        }
        if ( arg instanceof VarV ){
            double sum=0;
            VarV argV=(VarV)arg;
            for (int i = 0; i <this.size ; i++) {
                sum+=value[i]*argV.value[i];
            }
            return new VarF(sum);
        }
        if ( arg instanceof VarM ) {
            // умножение некоммутативно! построим матрицу из вектора
            double [] [] matr=new double[1][this.size];
            for (int i = 0; i < this.size; i++) {
                matr[0][i]=this.value[i];
            }
            return new VarM(matr).mul(arg);
        }
        return super.mul(arg);
    }

    @Override
    public Var div(Var arg) {
        if ( arg instanceof VarF ){
            double [] res=new double[this.size];
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]/((VarF)arg).value;
            }
            return new VarV(res);
        }
        return super.div(arg);
    }

    @Override
    public Var sub(Var arg) {
        if ( arg instanceof VarF ){
            double [] res=new double[this.size];
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]-((VarF)arg).value;
            }
            return new VarV(res);
        }
        if ( arg instanceof VarV ){
            double [] res=new double[this.size];
            VarV argV=(VarV)arg;
            if ( this.size!=argV.size )
            {
                new CalculatorError("операция вычитания векторов - разные размеры");
                return null;
            }
            for (int i = 0; i <this.size ; i++) {
                res[i]=value[i]-argV.value[i];
            }
            return new VarV(res);
        }
        return super.sub(arg);
    }
}
