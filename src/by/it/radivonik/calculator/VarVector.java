package by.it.radivonik.calculator;

import java.util.Arrays;
import java.util.regex.*;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class VarVector extends Var {
    private double[] vector;

    // Конструкторы
    public VarVector(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector,0,this.vector,0,vector.length);
    }

    public VarVector(VarVector var) {
        vector = new double[var.vector.length];
        System.arraycopy(var.vector,0,vector,0,var.vector.length);
    }

    public VarVector(String str) {
        fromString(str);
    }

    @Override
    public void fromString(String str) {
        Pattern p = Pattern.compile(IPatterns.ExVector);
        if (p.matcher(str).matches()) {
            p = Pattern.compile(IPatterns.ExNumber);
            Matcher m = p.matcher(str);
            int size = 0;
            while (m.find())
                size++;

            vector = new double[size];
            m.reset();
            int i = 0;
            while (m.find()) {
                vector[i] = Double.parseDouble(m.group().trim());
                i++;
            }
        }
        else {
            new Error("Ошибка: " + str + " не является вектором");
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

    public Var add(Var var) {
        double[] res = new double[vector.length];
        if (var instanceof VarFloat) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarFloat) var).getValue();
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
