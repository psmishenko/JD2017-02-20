package by.it.radivonik.calculator.variable;

import by.it.radivonik.calculator.parser.IPatterns;
import by.it.radivonik.calculator.exception.ParseException;

import java.util.regex.*;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class VarVector extends Var {
    private double[] vector;

    // Конструкторы
    public VarVector(double[] vector) {
        vectorCopy(vector);
    }

    public VarVector(VarVector var) {
        vectorCopy(var.vector);
    }

    public VarVector(String str) throws ParseException {
        fromString(str);
    }

    private void vectorCopy(double[] vector) {
        this.vector = new double[vector.length];
        System.arraycopy(vector,0,this.vector,0,vector.length);
    }

    @Override
    public void fromString(String str) throws ParseException {
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
            throw new ParseException(str + " не является вектором");
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

    public int length() {
        return vector.length;
    }

    public double getItem(int index) {
        return vector[index];
    }
}
