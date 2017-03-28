package by.it.smirnov.jd01_15_matlab.Vars;

import by.it.smirnov.jd01_15_matlab.Error.MatLabException;
import by.it.smirnov.jd01_15_matlab.Parser.Patterns;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для работы с матрицами
 */
public class VarM extends Var {
    private Double[][] value;

    public Double[][] getValue() {
        return value;
    }

    private void checkArray(VarM a, VarM b) throws MatLabException {
        if ((a.value.length!=(b.value.length))||
                (a.value[0].length!=(b.value[0].length)))
            throw new MatLabException("Для операции над матрицами необходимо чтобы матрицы были одного размера");
    }

    @Override
    public void setFrom(String x) throws MatLabException {
        try {
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
                throw new MatLabException("Строка "+x+" не является массивом");
            }
        } catch (MatLabException e) {
            throw new MatLabException(e.getMessage());
        }
        catch (NumberFormatException e) {
            throw new MatLabException(String.format("Ошибка разбора чисел в матрице \"%s\": %s", x, e.getMessage()));
        }
    }

    /**
     * Сложение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var add(Var var) throws MatLabException {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] + ((VarF) var).getValue();
            }
        } else if (var instanceof VarM) {
            checkArray(this, (VarM) var);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] + ((VarM) var).value[i][j];
            }
        } else return super.add(var);

        return new VarM(res);
    }

    /**
     * Вычитание
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var sub(Var var) throws MatLabException {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] - ((VarF) var).getValue();
            }
        } else if (var instanceof VarM) {
            checkArray(this, (VarM) var);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] - ((VarM) var).value[i][j];
            }
        } else return super.sub(var);

        return new VarM(res);
    }

    /**
     * Деление
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var div(Var var) throws MatLabException {
        Double[][] res = new Double[value.length][value[0].length];
        if (var instanceof VarF) {
            if (((VarF) var).getValue() == 0) throw new MatLabException("Деление на ноль");
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] / ((VarF) var).getValue();
            }
        } else return super.div(var);

        return new VarM(res);
    }

    /**
     * Умножение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var mul(Var var) throws MatLabException {
        if (var instanceof VarF) {
            Double[][] res = new Double[value.length][value[0].length];
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++)
                    res[i][j] = value[i][j] * ((VarF) var).getValue();
            }
            return new VarM(res);
        } else if (var instanceof VarV) {
            if ((value[0].length==((VarV) var).getValue().length)) {
                Double[] res = new Double[value.length];
                for (int i = 0; i < value.length; i++) {
                    res[i] = 0d;
                    for (int j = 0; j < ((VarV) var).getValue().length; j++)
                        res[i] += value[i][j]*((VarV) var).getValue()[j];
                }
                return new VarV(res);
            } else {
                throw new MatLabException("Для умножения необходимо чтобы кол-во столбцов первой матрицы было равно длине вектора");
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
                throw new MatLabException("Для умножения необходимо чтобы кол-во столбцов первой матрицы было равно кол-ву строк второй матрицы");
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

    public VarM(String var) throws MatLabException {
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
