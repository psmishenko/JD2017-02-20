package by.it.prigozhanov.my_matlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 4/12/2017.
 *
 * @author v-omf
 */
public class VarVector extends Var {
    public Double[] vector;

    private boolean isLenghEquals(VarVector varVector1, VarVector varVector2) throws MatlabException {
        boolean res = false;
        if (varVector1.vector.length != varVector2.vector.length) {
        throw new MatlabException("Длинны векторов не совпадают");
        }
        else return true;

    }

    public VarVector(Double[] values) {
        this.vector = values;
    }

    public VarVector(String stringVector) {
        fromString(stringVector);
    }

    public VarVector(VarVector var) {
    this.vector = new Double[var.vector.length];
        for (int i = 0; i < var.vector.length; i++) {
            this.vector[i] = var.vector[i];
        }
    }

    @Override
    public Var add(Var var) throws MatlabException {
        if (var instanceof VarValue) {
            Double[] res = new Double[this.vector.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.vector[i] + ((VarValue) var).value;
            }
            return new VarVector(res);
        }
        if (var instanceof VarVector) {
            VarVector operand = (VarVector) var;
            if (isLenghEquals(this, operand)) {
                Double[] res = new Double[((VarVector) var).vector.length];
                for (int i = 0; i < operand.vector.length; i++) {
                    res[i] = this.vector[i] + operand.vector[i];
                }
                return new VarVector(res);
            } else System.out.println("Операция не возможна, векторы имеют разные длинны");
        }
        return super.add(var);
    }

    @Override
    public Var sub(Var var) throws MatlabException {
        if (var instanceof VarValue) {
            Double[] res = new Double[this.vector.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.vector[i] - ((VarValue) var).value;
            }
            return new VarVector(res);
        }
        if (var instanceof VarVector) {
            VarVector operand = (VarVector) var;
            if (isLenghEquals(this, operand)) {
                Double[] res = new Double[((VarVector) var).vector.length];
                for (int i = 0; i < operand.vector.length; i++) {
                    res[i] = this.vector[i] - operand.vector[i];
                }
                return new VarVector(res);
            } else System.out.println("Операция не возможна, векторы имеют разные длинны");
        }
        return super.sub(var);
    }

    @Override
    public Var div(Var var) throws MatlabException {
        if (var instanceof VarValue) {
            Double[] res = new Double[this.vector.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.vector[i] / ((VarValue) var).value;
            }
            return new VarVector(res);
        }
        if (var instanceof VarVector) {
            VarVector operand = (VarVector) var;
            if (isLenghEquals(this, operand)) {
                Double[] res = new Double[((VarVector) var).vector.length];
                for (int i = 0; i < operand.vector.length; i++) {
                    res[i] = this.vector[i] / operand.vector[i];
                }
                return new VarVector(res);
            } else System.out.println("Операция не возможна, векторы имеют разные длинны");
        }
        return super.add(var);
    }

    @Override
    public Var mul(Var var) throws MatlabException {
        if (var instanceof VarValue) {
            Double[] res = new Double[this.vector.length];
            for (int i = 0; i < res.length; i++) {
                res[i] = this.vector[i] * ((VarValue) var).value;
            }
            return new VarVector(res);
        }
        if (var instanceof VarVector) {
            VarVector operand = (VarVector) var;
            if (isLenghEquals(this, operand)) {
                Double[] res = new Double[((VarVector) var).vector.length];
                for (int i = 0; i < operand.vector.length; i++) {
                    res[i] = this.vector[i] * operand.vector[i];
                }
                return new VarVector(res);
            } else System.out.println("Операция не возможна, векторы имеют разные длинны");
        }
        if (var instanceof VarMatrix) {
            return var.mul(this);
        }
        return super.mul(var);
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder("{");
        for (int i = 0; i < this.vector.length; i++) {
            vector.append(this.vector[i]);
            if (i + 1 != this.vector.length) vector.append(",");
        }
        vector.append("}");
        return vector.toString();
    }

    @Override
    public void fromString(String stringValue) {
        if (stringValue.matches(Expressions.VECTOR)) {
            Pattern pattern = Pattern.compile(Expressions.VALUE);
            Matcher m = pattern.matcher(stringValue);
            int size = 0;
            while (m.find()) size++;
            this.vector = new Double[size];
            int index = 0;
            m.reset();
            while (m.find()) {
                vector[index] = Double.parseDouble(m.group());
                index++;
            }
        } else System.out.println("Не является вектором");
    }
}
