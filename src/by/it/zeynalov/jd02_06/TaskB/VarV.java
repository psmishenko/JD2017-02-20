package by.it.zeynalov.jd02_06.TaskB;

import by.it.zeynalov.jd01_09_matlab.Error;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.zeynalov.jd01_09_matlab.Patterns.exVal;
import static by.it.zeynalov.jd01_09_matlab.Patterns.exVec;

public class VarV extends Var {
    private float[] vector;

    public VarV(String sg) {
        fromString(sg);
    }

    private void checkSize(VarV v1, VarV v2) throws MathException {
        if (v1.vector.length != v2.vector.length) {
            throw new MathException("Разный размер у векторов");
        }
    }

    public VarV(float[] vector) {
        this.vector = vector;
    }

    @Override
    public void fromString(String value) {
        Pattern p = Pattern.compile(exVec);
        if (p.matcher(value).matches()) {
            p = Pattern.compile(exVal);
            Matcher m = p.matcher(value);
            int size = 0;
            while (m.find()) size++;
            vector = new float[size];
            m.reset();
            int i = 0;
            while (m.find()) {
                String oneValue = m.group();
                vector[i] = Float.parseFloat(oneValue);
                i++;
            }
        } else {
            new Error("Ошибка:" + value + " не является вектором");
        }
    }

    @Override
    public Var add(Var var) throws MathException {
        float[] res = new float[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkSize(this, (VarV) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarV) var).vector[i];
            }
        } else return super.add(var);

        return new VarV(res);
    }

    @Override
    public Var sub(Var var) throws MathException {
        float[] res = new float[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkSize(this, (VarV) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarV) var).vector[i];
            }
        } else return super.add(var);

        return new VarV(res);
    }

    @Override
    public String toString() {
        return "VarV" + Arrays.toString(vector);
    }

    @Override
    public Var mul(Var var) throws MathException {
        float[] res = new float[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] * ((VarF) var).getValue();
            }
        } else if (var instanceof VarV) {
            checkSize(this, (VarV) var);
            float sum = 0.0f;
            for (int i = 0; i < res.length; i++) {
                sum = sum + vector[i] * ((VarV) var).vector[i];
            }
            History.getInstance().addMesage("Выполнено: " + this + " * " + var + " = " +  new VarF(sum));
            return new VarF(sum);
        } else return super.add(var);

        return new VarV(res);
    }

    @Override
    public Var div(Var var) throws MathException {
        float[] res = new float[vector.length];
        if (var instanceof VarF) {
            if (((VarF) var).getValue() == 0) {
                throw new MathException("Деление на ноль");
            }
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] / ((VarF) var).getValue();
            }
        } else return super.div(var);
        return new VarV(res);
    }

}
