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

    public VarFloat(VarFloat var) {
        this.value = var.value;
    }

    public VarFloat(String str) {
        fromString(str);
    }

    @Override
    public void fromString(String str) {
        this.value = Double.parseDouble(str);
    }

    @Override
    public String toString() {
        return Double.toString(value);
    }

    public double getValue() {
        return value;
    }
}
