package by.it.smirnov.jd02_06_matlab.Vars;

import by.it.smirnov.jd02_06_matlab.Error.MatLabException;
import by.it.smirnov.jd02_06_matlab.Parser.Patterns;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс для работы с векторами
 */
public class VarV extends Var {
    private Double[] value;

    public Double[] getValue() {
        return value;
    }

    private void checkVector(VarV a, VarV b) throws MatLabException {
        if (a.value.length != b.value.length)
            throw new MatLabException("Для операции над векторами необходимо чтобы вектора были равны");
    }

    @Override
    public void setFrom(String x) throws MatLabException {
        try {
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
                throw new MatLabException("Строка "+x+" не является вектором");
            }
        } catch (MatLabException e) {
            throw new MatLabException(e.getMessage());
        }
        catch (NumberFormatException e) {
            throw new MatLabException(String.format("Ошибка разбора чисел в векторе \"%s\": %s", x, e.getMessage()));
        }
    }

    /**
     * Сложение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var add(Var var) throws MatLabException {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] + ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkVector(this, (VarV) var);
            for (int i = 0; i < res.length; i++)
                res[i] = value[i] + ((VarV) var).value[i];
        } else return super.add(var);

        return new VarV(res);
    }

    /**
     * Вычитание
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var sub(Var var) throws MatLabException {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] - ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkVector(this, (VarV) var);
            for (int i = 0; i < res.length; i++)
                res[i] = value[i] - ((VarV) var).value[i];
        } else return super.sub(var);

        return new VarV(res);
    }

    /**
     * Деление
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var div(Var var) throws MatLabException {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            if (((VarF) var).getValue() == 0) throw new MatLabException("Деление на ноль");
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] / ((VarF) var).getValue();
            }
        } else return super.div(var);

        return new VarV(res);
    }

    /**
     * Умножение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var mul(Var var) throws MatLabException {
        Double[] res = new Double[value.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = value[i] * ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkVector(this, (VarV) var);
            Double sum = 0.0;
            for (int i = 0; i < res.length; i++)
                sum += value[i] * ((VarV) var).value[i];
            return new VarF(sum);
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

    public VarV(String var) throws MatLabException {
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
