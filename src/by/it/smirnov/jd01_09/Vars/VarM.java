package by.it.smirnov.jd01_09.Vars;

import by.it.smirnov.jd01_09.Error.Error;
import by.it.smirnov.jd01_09.Parser.Patterns;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by aleksey.smirnov on 13.03.2017.
 */
public class VarM extends Var {
    public Double[][] value;
    @Override
    public void setFrom(String x) {
        Pattern p = Pattern.compile(Patterns.exMat);
        if (p.matcher(x).matches()) {// является ли строка матрицей
            Pattern pVec = Pattern.compile(Patterns.exVec);
            Pattern pVal = Pattern.compile(Patterns.exVal);
            Matcher mVec=pVec.matcher(x);
            Matcher mVal;
            int rows=0;
            int cols=0;
            while (mVec.find()) {
                mVal = pVal.matcher(mVec.group());
                if (rows == 0)
                    while (mVal.find()) cols++;
                rows++;
            }

            this.value = new Double[rows][cols];
            mVec.reset();
            int row=0;
            int col;
            while (mVec.find()) {
                col=0;
                mVal = pVal.matcher(mVec.group());
                while (mVal.find()){
                    value[row][col]=Double.parseDouble(mVal.group());
                    col++;
                };
                row++;
            }
        } else {
            new Error("Строка "+x+" не является массивом");
        }
    }

    @Override
    public Var add(Var var) {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] + ((VarF) var).value;
            }
        } else if (var instanceof VarM) {
            if ((value.length==((VarM) var).value.length)&&
            (value[0].length==((VarM) var).value[0].length)) {
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++)
                        res[i][j] = value[i][j] + ((VarM) var).value[i][j];
                }
            } else {
                new Error("Для сложения необходимо чтобы матрицы были одного размера");
                return null;
            }
        } else return super.add(var);

        return new VarM(res);
    }

    @Override
    public Var sub(Var var) {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] - ((VarF) var).value;
            }
        } else if (var instanceof VarM) {
            if ((value.length==((VarM) var).value.length)&&
                    (value[0].length==((VarM) var).value[0].length)) {
                for (int i = 0; i < res.length; i++) {
                    for (int j = 0; j < res[0].length; j++)
                        res[i][j] = value[i][j] - ((VarM) var).value[i][j];
                }
            } else {
                new Error("Для вычитания необходимо чтобы матрицы были одного размера");
                return null;
            }
        } else return super.sub(var);

        return new VarM(res);
    }

    @Override
    public Var div(Var var) {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] / ((VarF) var).value;
            }
        } else return super.div(var);

        return new VarM(res);
    }

    @Override
    public Var mul(Var var) {
        if (var instanceof VarF) {
            Double[][] res = new Double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] * ((VarF) var).value;
            }
            return new VarM(res);
        } else if (var instanceof VarV) {
            if ((value[0].length==((VarV) var).value.length)) {
                Double[] res = new Double[value.length];
                for (int i = 0; i < value.length; i++) {
                    res[i] = 0d;
                    for (int j = 0; j < ((VarV) var).value.length; j++)
                        res[i] += value[i][j]*((VarV) var).value[j];
                }
                return new VarV(res);
            } else {
                new Error("Для умножения необходимо чтобы кол-во столбцов первой матрицы было равно длине вектора");
                return null;
            }
        } else if (var instanceof VarM) {
            if ((value[0].length==((VarM) var).value.length)) {
                Double[][] res = new Double[value.length][((VarM) var).value[0].length];
                for (int i = 0; i < value.length; i++)
                    for (int j = 0; j < ((VarM) var).value[0].length; j++) {
                        res[i][j] = 0d;
                        for (int k = 0; k < ((VarM) var).value.length; k++)
                            res[i][j] += value[i][k]*((VarM) var).value[k][j];
                    }
                return new VarM(res);
            } else {
                new Error("Для умножения необходимо чтобы кол-во столбцов первой матрицы было равно кол-ву строк второй матрицы");
                return null;
            }
        } else return super.add(var);
    }

    public VarM(VarM var) {
        value = new Double[var.value.length][var.value[0].length];
        for (int i = 0; i < var.value.length; i++) {
            System.arraycopy(var.value[i],0, value[i], 0, var.value[i].length);
        }
        System.arraycopy(var,0, value, 0, var.value.length);
    }

    public VarM(Double[][] var) {
        value = new Double[var.length][var[0].length];
        for (int i = 0; i < var.length; i++) {
            System.arraycopy(var[i],0, value[i], 0, var[i].length);
        }

    }

    public VarM(String var) {
        setFrom(var);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i < this.value.length; i++) {
            Double[] arr = this.value[i];
            sb.append('{');
            String delimiter = "";
            for (Double one:arr) {
                sb.append(delimiter);
                sb.append(String.format(Locale.ROOT,"%.2f",one));
                delimiter=",";
            }
            sb.append('}');
            if (i!=this.value.length-1) sb.append(',');
        }
        sb.append('}');
        return sb.toString();

    }

}
