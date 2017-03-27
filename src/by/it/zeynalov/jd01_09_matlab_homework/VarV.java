package by.it.zeynalov.jd01_09_matlab_homework;

import by.it.zeynalov.jd01_09_matlab.*;
import by.it.zeynalov.jd01_09_matlab.Error;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.zeynalov.jd01_09_matlab.Patterns.exVal;
import static by.it.zeynalov.jd01_09_matlab.Patterns.exVec;

public class VarV extends Var {
    private float[] vector;

    private void checkSize(VarV v1, VarV v2) throws MathException {
        if (v1.vector.length!= v2.vector.length) {
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
        return super.add(var);
    }

    @Override
    public Var mul(Var var) throws MathException {
        return super.mul(var);
    }

    @Override
    public Var div(Var var) throws MathException {
        return super.div(var);
    }

    @Override
    public Var sub(Var var) throws MathException {
        return super.sub(var);
    }

}
