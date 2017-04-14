package by.it.smirnov.jd02_06_matlab.Vars;

import by.it.smirnov.jd02_06_matlab.Error.MatLabException;

import java.util.Locale;

/**
 * Класс для работы с вещественными числами
 */
public class VarF extends Var {
    private Double value;

    public Double getValue() {
        return value;
    }

    public VarF(String value) throws MatLabException {
        setFrom(value);
    }
    public VarF(double value) {
        this.value = value;
    }
    public VarF(VarF value) {
        this.value = value.value;

    }

    /**
     * Сложение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var add(Var var) throws MatLabException {
        if (var instanceof VarF) {
            return new VarF(this.value+((VarF) var).value);
        }
        else
            return (var.add(this));
        //return super.add(var);
    }

    /**
     * Вычитание
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var sub(Var var) throws MatLabException {
        if (var instanceof VarF) {
            return new VarF(this.value-((VarF) var).value);
        }
        else
            return super.sub(var);

    }

    /**
     * Умножение
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var mul(Var var) throws MatLabException {
        if (var instanceof VarF) {
            return new VarF(this.value*((VarF) var).value);
        }
        else
            return (var.mul(this));
    }

    /**
     * Деление
     * @param var второй операнд
     * @return Var результат
     */
    @Override
    public Var div(Var var) throws MatLabException {
        if (var instanceof VarF) {
            if (((VarF) var).value == 0) throw new MatLabException("Деление на ноль");
            return new VarF(this.value/((VarF) var).value);
        }
        else
            return super.div(var);
    }

    @Override
    public void setFrom(String x) throws MatLabException {
        try {
            this.value=Double.parseDouble(x);
        } catch (NumberFormatException e) {
            throw new MatLabException(String.format("Нельзя преобразовать \"%s\" в число", x));
        }
    }

    @Override
    public String toString() {
        return String.format(Locale.ROOT, "%.2f",value);
        //value.toString();
    }
}
