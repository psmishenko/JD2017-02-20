package by.it.tereshko.matlab;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {

    private Double[] vector;


    @Override
    public Var add(Var var) {
        System.out.println("Caught addition of vector with something");
        return null;
    }

    public VarV(VarV copyFrom) {
        vector = new Double[copyFrom.vector.length];
//        for (int i = 0; i < copyFrom.vector.length; i++) {
//            vector[i] = copyFrom.vector[i];
//        } the same as System.arraycopy(copyFrom.vector, 0, vector, 0, vector.length);
        System.arraycopy(copyFrom.vector, 0, vector, 0, vector.length);
    }

    public VarV(Double[] vector) {
        this.vector = new Double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    @Override
    public void fromString(String value) {
        Pattern p = Pattern.compile(Patterns.exVec);
        if (p.matcher(value).matches()) {
            p = Pattern.compile(Patterns.exVal);
            Matcher m = p.matcher(value);
            int size = 0;
            while (m.find()) size++;
            vector = new Double[size];
            m.reset();
            int i = 0;
            while (m.find()) {
                String one = m.group();
                vector[i] = Double.parseDouble(one);
                i++;
            }
        } else {
            new Error("Error:" + value + " is not a vector");
        }
    }

    public VarV(String value) {
        fromString(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (Double one : vector) {
            sb.append(delimiter);
            sb.append(one.toString());
            delimiter = ",";
        }
        sb.append("}");
        return sb.toString();
    }
}
