package by.it.kolenda.MatLab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {
    private Double[] vector;


    @Override
    public Var add(Var var) {
        System.out.println("Поймали сложение вектора с чем-либо");
        return null;
    }

    public VarV(VarV copyFrom) {
        this.vector = new Double[vector.length];
        //for (int i = 0; i < copyFrom.vector.length; i++) {
        //    vector[i]=copyFrom.vector[i];
        //}
        System.arraycopy(copyFrom.vector, 0, vector, 0, vector.length);
    }


    public VarV(Double[] vector) {
        this.vector = new Double[vector.length];

    }

    @Override
    public void fromString(String value) {
    }

    public VarV(String str) {
        Pattern p = Pattern.compile(Patterns.exVec);
        if (p.matcher(str).matches()) {
            p = Pattern.compile(Patterns.exVec);
            Matcher m = p.matcher(str);
            int size = 0;
            while (m.find()) size++;
            vector = new Double[size];
            m.reset();
            int i = 0;
            while (m.find()) {

                String oneValue = m.group();
                vector[i] = Double.parseDouble(oneValue);
                i++;
            }
//            String[] values=str.split(Patterns.exVal);
        } else {
            new Error("Error:" + str + " is not a vector");
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{")
        String delimiter = "";
        for (Double one : vector) {

        }
        sb.append('}');
        return "(" + Arrays.toString(vector) + ")";
    }
}
