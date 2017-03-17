package by.it.radivonik.calculator;

import java.util.Arrays;
import java.util.regex.*;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class VarVector extends Var {
    private Double[] vector;

    public VarVector(VarVector var) {
        vector = new Double[var.vector.length];
        /*
        for (int i = 0; i < var.vector.length; i++) {
            vector[i] = var.vector[i];
        }
         */
        System.arraycopy(var.vector,0,vector,0,var.vector.length);
    }

    public VarVector(Double[] value) {
        vector = new Double[value.length];
        System.arraycopy(value,0,vector,0,vector.length);
    }

    public VarVector(String value) {
        fromString(value);
    }

    @Override
    public void fromString(String value) {
        Pattern p = Pattern.compile(IPatterns.exVec);
        if (p.matcher(value).matches()) {
            p = Pattern.compile(IPatterns.exVal);
            Matcher m = p.matcher(value);
            int size = 0;
            while (m.find())
                size++;

            vector = new Double[size];
            m.reset();
            int i = 0;
            while (m.find()) {
                vector[i] = Double.parseDouble(m.group().trim());
                i++;
            }
        }
        else {
            new Error("Ошибка: " + value + " не является вектором");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        String delim = "";
        for (Double one : vector) {
            res.append(delim);
            res.append(one.toString());
            delim = ",";
        }
        res.append("}");
        return res.toString();
    }

    @Override
    public Var add(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarFloat) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarFloat) var).value;
            }
        }
        else if (var instanceof VarVector) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] +  ((VarVector) var).vector[i];
            }
        }
        return new VarVector(res);
    }


}
