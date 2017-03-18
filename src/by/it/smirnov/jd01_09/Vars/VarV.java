package by.it.smirnov.jd01_09.Vars;

import by.it.smirnov.jd01_09.Error.Error;
import by.it.smirnov.jd01_09.Parser.Patterns;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public class VarV extends Var {
    public Double[] value;
    @Override
    public void setFrom(String x) {
        Pattern p = Pattern.compile(Patterns.exVec);
        if (p.matcher(x).matches()) {// является ли строка вектором
            p = Pattern.compile(Patterns.exVal);
            Matcher m=p.matcher(x);
            int size=0;
            while (m.find()) size++;
            this.value = new Double[size];
            m.reset();
            int i=0;
            while (m.find()) {
                value[i]=Double.parseDouble(m.group());
                i++;
            }
        } else {
            new Error("Строка "+x+" не является вектором");
        }

    }

    @Override
    public Var add(Var var) {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] + ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            if (value.length == ((VarV) var).value.length)
            {
                for (int i = 0; i < res.length; i++)
                    res[i] = value[i] + ((VarV) var).value[i];
            } else {
                new Error("Для сложения векторов необходимо чтобы вектора были равны");
                return null;
            }
        } else return super.add(var);

        return new VarV(res);
    }

    @Override
    public Var sub(Var var) {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] - ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            if (value.length == ((VarV) var).value.length)
            {
            for (int i = 0; i < res.length; i++)
                res[i] = value[i] - ((VarV) var).value[i];
            } else {
                new Error("Для вычитания векторов необходимо чтобы вектора были равны");
                return null;
            }
        } else return super.sub(var);

        return new VarV(res);
    }

    @Override
    public Var div(Var var) {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] / ((VarF) var).value;
            }
        } else return super.div(var);

        return new VarV(res);
    }

    @Override
    public Var mul(Var var) {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] * ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            if (value.length == ((VarV) var).value.length) {
                Double sum = 0.0;
                for (int i = 0; i < res.length; i++)
                    sum += value[i] * ((VarV) var).value[i];
                return new VarF(sum);
            } else {
                new Error("Для умножения векторов необходимо чтобы вектора были равны");
                return null;
            }
        } else return super.mul(var);

        return new VarV(res);
    }

    public VarV(VarV var) {
        value = new Double[var.value.length];
        System.arraycopy(var,0, value, 0, var.value.length);
    }

    public VarV(Double[] var) {
        value = new Double[var.length];
        System.arraycopy(var,0, value, 0, var.length);
    }

    public VarV(String var) {
        setFrom(var);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (Double one:this.value) {
          sb.append(delimiter);
          sb.append(String.format(Locale.ROOT, "%.2f",one));
          delimiter=",";
        }
        sb.append('}');
        return sb.toString();

    }

}
