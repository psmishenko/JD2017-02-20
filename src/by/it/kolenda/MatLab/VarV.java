package by.it.kolenda.MatLab;


import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var {
    public Double[] vector;


    @Override
    public Var add(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarF) var).value;
            }

        }
        else if (var instanceof VarV){
            for (int i = 0; i < res.length; i++) {
                res[i]=vector[i] + ((VarF) var).value;

            }
        }
        else return super.add(var);

        return new VarV(res);

        }

    @Override
    public Var sub(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarF) var).value;
            }

        }
        else if (var instanceof VarV){
            for (int i = 0; i < res.length; i++) {
                res[i]=vector[i] + ((VarF) var).value;

            }
        }
        else return super.add(var);

        return new VarV(res);

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

        } else {
            new Error("Error:" + str + " is not a vector");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String delimiter = "";
        for (Double one:vector) {
            sb.append(delimiter);
            sb.append(one.toString());
            delimiter=",";
        }
        sb.append('}');
        return "(" + Arrays.toString(vector) + ")";
    }
}
