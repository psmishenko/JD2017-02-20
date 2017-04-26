package by.it.Zyryanov.my_MatLab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarVector extends Var{


    public Double [] vector;


    private boolean checkSize(VarVector v1, VarVector v2) {
        if (v1.vector.length != v2.vector.length){
            System.out.println("Ошибка! Разные размеры векторов");
            Singleton.getInstance().errorLogger("Ошибка! Разные размеры векторов (17 строка VarVector)");
            return false;
        } else
            return true;
    }


    @Override
    public Var add(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarValue) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarValue)var).value;
            }
        } else if (var instanceof VarVector) {
            checkSize(this,(VarVector) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] + ((VarVector) var).vector[i];
            }
        } else return super.add(var);

        return new VarVector(res);
    }



    @Override
    public Var sub(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarValue) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarValue)var).value;
            }
        } else if (var instanceof VarVector) {
            checkSize(this,(VarVector) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] - ((VarVector) var).vector[i];
            }
        } else return super.add(var);

        return new VarVector(res);
    }


    @Override
    public Var mul(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarValue) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] * ((VarValue)var).value;
            }
        } else if (var instanceof VarVector) {
            checkSize(this,(VarVector) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] * ((VarVector) var).vector[i];
            }
        } else return super.add(var);

        return new VarVector(res);
    }


    @Override
    public Var div(Var var) {
        Double[] res = new Double[vector.length];
        if (var instanceof VarValue) {
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] / ((VarValue)var).value;
            }
        } else if (var instanceof VarVector) {
            checkSize(this,(VarVector) var);
            for (int i = 0; i < res.length; i++) {
                res[i] = vector[i] / ((VarVector) var).vector[i];
            }
        } else return super.add(var);

        return new VarVector(res);
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

    @Override
    public void fromString(String var) {
        Pattern p = Pattern.compile(Expressions.VECTOR);
        if (p.matcher(var).matches()){
            p = Pattern.compile(Expressions.VALUE);
            Matcher m = p.matcher(var);
            int size = 0;
            while (m.find()) size++;
            vector = new Double[size];
            m.reset();
            int i = 0;
            while(m.find()){
                String oneValue = m.group();
                vector[i] = Double.parseDouble(oneValue);
                i++;
            }
        }
    }

    public VarVector(VarVector copy){
        for (int i = 0; i < copy.vector.length; i++) {
            vector[i] = copy.vector[i];
        }
        System.arraycopy(copy.vector, 0, vector, 0, vector.length);
    }

    public VarVector(Double[] vector) {
        this.vector = new Double[vector.length];
        System.arraycopy(vector, 0, this.vector, 0, vector.length);
    }

    public VarVector(String value) {
        fromString(value);
    }


}
