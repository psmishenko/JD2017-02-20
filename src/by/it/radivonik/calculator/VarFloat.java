package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class VarFloat extends Var {
    private double value;

    // Конструкторы
    public VarFloat(double value) {
        this.value = value;
    }

    public VarFloat(VarFloat var) throws ParseException {
        this.value = var.value;
    }

    public VarFloat(String str) throws ParseException {
        fromString(str);
    }

    @Override
    public void fromString(String str) throws ParseException {
        try {
            this.value = Double.parseDouble(str);
        }
        catch (Exception e) {
            throw new ParseException(str + "не является числом");
        }
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }
}
