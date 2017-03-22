package by.it.psmishenko.matlab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class
VarV extends Var {
    public Double[] vector;
private void ckeckSize(VarV v1, VarV v2)throws MathException{
    if(v1.vector.length!=v2.vector.length){
        throw new MathException("Разный размер у векторов");
    }
}
    @Override
    public Var add(Var var) throws MathException {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarV) var).vector[i];
            }
        } else return super.add(var);
        return new VarV(res);
    }

    @Override
    public Var sub(Var var) throws MathException {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarV) var).vector[i];
            }
        } else return super.sub(var);
        return new VarV(res);
    }

    @Override
    public Var mul(Var var) throws MathException {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] * ((VarF) var).value;
            }
        } else if (var instanceof VarV) {
            Double sum = 0.0;

            for (int i = 0; i < res.length; i++) {
                sum += res[i] = vector[i] * ((VarV) var).vector[i];

            }
            return new VarF(sum);
        } else return super.mul(var);
        return new VarV(res);
    }

    @Override
    public Var div(Var var) throws MathException {
        Double[] res = new Double[vector.length];
        if (var instanceof VarF) {
            if(((VarF)var).value==0) throw new MathException("Умножение ");
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] / ((VarF) var).value;
            }
        } else return super.div(var);
        return new VarV(res);
    }

    public VarV(VarV copyFrom) {
        vector = new Double[copyFrom.vector.length];
        //  for (int i = 0; i <copyFrom.vector.length ; i++) {
        //    vector[i] = copyFrom.vector[i];
        //}
        System.arraycopy(copyFrom.vector, 0, vector, 0, vector.length);
    }

    public VarV(Double[] vector) {
        this.vector = new Double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }


    @Override
    public void fromString(String str) {
        Pattern p = Pattern.compile(Patterns.exVec);
        if (p.matcher(str).matches()) {
            p = Pattern.compile(Patterns.exVal);
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
            new Error("Ошибка: " + str + "  не является вектором ");
        }
    }

    public VarV(String str) {
        fromString(str);
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
