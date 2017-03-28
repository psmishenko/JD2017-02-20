package by.it.korzun.matlab;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var{
    private double[][] matrix;

    VarM(String str) {
        Pattern patternArgs = Pattern.compile("[{}\\[\\]]");
        Matcher matcher = patternArgs.matcher(str);
        String[] strings = str.split("[}\\]],\\s?[\\[{]");
        for (int i = 0; i < strings.length; i++) {
            matcher = patternArgs.matcher(strings[i]);
            strings[i] = matcher.replaceAll("");
        }
        String[][] matrix = new String[strings.length][];
        for (int i = 0; i < matrix.length; i++) {
            String[] temp = strings[i].split(",");
            matrix[i] = new String[temp.length];
            System.arraycopy(temp, 0, matrix[i], 0, matrix[0].length);
        }
        this.matrix = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                this.matrix[i][j] = Double.parseDouble(matrix[i][j]);
            }
        }
    }

    @Override
    public Var add(Var var) throws MathException{
        if(var instanceof  VarF){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] += Double.parseDouble(var.toString());
                }
            }
            return this;
        }else if(var instanceof VarM){
            if(((VarM) var).matrix.length == this.matrix.length && ((VarM) var).matrix[0].length == this.matrix[0].length) {
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < this.matrix[i].length; j++) {
                        this.matrix[i][j] += ((VarM) var).matrix[i][j];
                    }
                }
                return this;
            }else{
                throw new MathException("Несовпадающие размеры:");
            }
        }
        else{
            return (var.add(this));
        }
    }

    @Override
    public Var sub(Var var) throws MathException{
        if(var instanceof VarM){
            if(((VarM) var).matrix.length == this.matrix.length && ((VarM) var).matrix[0].length == this.matrix[0].length) {
                for (int i = 0; i < this.matrix.length; i++) {
                    for (int j = 0; j < this.matrix[i].length; j++) {
                        this.matrix[i][j] -= ((VarM) var).matrix[i][j];
                    }
                }
                return this;
            }else{
                throw new MathException("Несовпадающие размеры:");
            }

        }
        else if(var instanceof VarF){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] -= ((VarF) var).value;
                }
            }
            return this;
        }
        else{
            return super.sub(var);
        }
    }

    @Override
    public Var mul(Var var) throws MathException{
        if(var instanceof  VarF){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] *= Double.parseDouble(var.toString());
                }
            }
            return this;
        }else if(var instanceof VarM){
            this.matrix = MatrixMethods.arrayMulVector(this.matrix, ((VarM) var).matrix);
            return this;
        }else if(var instanceof VarV){
            VarV res = new VarV();
            res.vector = MatrixMethods.arrayMulVector(this.matrix, ((VarV) var).vector);
            return res;
        }
        else{
            return (var.add(this));
        }
    }

    @Override
    public Var div(Var var) throws MathException{
        return super.div(var);
    }

    @Override
    public void fromString(String value) {

    }

    @Override
    public String toString() {
        String str = "[";
        for (int i = 0; i < matrix.length; i++) {
            str += "[";
            for (int j = 0; j < matrix[0].length; j++) {
                if(j != matrix[0].length - 1) {
                    str += matrix[i][j] + ", ";
                }else{
                    if(i != matrix.length - 1) {
                        str += matrix[i][j] + "], ";
                    }else{
                        str += matrix[i][j] + "]";
                    }
                }
            }
        }
        str += "]";
        return str;
    }
}
