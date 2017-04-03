package by.it.korzun.matlab;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarV extends Var{
    public double []vector;

    VarV() {
    }

    VarV(String str){
        Pattern patternArgs = Pattern.compile("[\\[{}\\]]");
        Matcher matcher = patternArgs.matcher(str);
        str = matcher.replaceAll("");
        String []elements = str.split(",");
        vector = new double[elements.length];
        for (int i = 0; i < elements.length; i++) {
            vector[i] = Double.parseDouble(elements[i]);
        }
    }

    private void checkSize(VarV v1, VarV v2) throws MathException{
        if(v1.vector.length != v2.vector.length){
            throw new MathException("Разная длина векторов:");
        }
    }

    @Override
    public Var add(Var var) throws MathException{
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] += Double.parseDouble(var.toString());
            }
            return this;
        }else if(var instanceof VarV){
            checkSize(this, (VarV) var);
            if(((VarV) var).vector.length == this.vector.length) {
                for (int i = 0; i < this.vector.length; i++) {
                    this.vector[i] += ((VarV) var).vector[i];
                }
                return this;
            }else {
                throw new MathException("Несовпадающие размеры:");
            }
        }
        else if(!(var instanceof VarM)){
            return (var.add(this));
        }else
            return super.add(var);

    }

    @Override
    public Var sub(Var var) throws MathException{
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] -= Double.parseDouble(var.toString());
            }
            return this;
        }
        else if(var instanceof VarV){
            checkSize(this, (VarV) var);
            if(((VarV) var).vector.length == this.vector.length) {
                for (int i = 0; i < this.vector.length; i++) {
                    this.vector[i] -= ((VarV) var).vector[i];
                }
                return this;
            }else{
                throw new MathException("Несовпадающие размеры:");
            }
        }else {
            return super.sub(var);
        }
    }
    @Override
    public Var mul(Var var) throws MathException{
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] *= Double.parseDouble(var.toString());
            }
            return this;
        }
        else if(var instanceof VarV){
            checkSize(this, (VarV) var);
            if(((VarV) var).vector.length == this.vector.length) {
                for (int i = 0; i < this.vector.length; i++) {
                    this.vector[i] *= ((VarV) var).vector[i];
                }
                return this;
            }else{
                throw new MathException("Несовпадающие размеры:");
            }
        }else {
            return (var.add(this));
        }
    }
    @Override
    public Var div(Var var) throws MathException{
        if(var instanceof  VarF){
            if(((VarF) var).value == 0){
                throw new MathException("Деление на ноль:");
            }
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] /= Double.parseDouble(var.toString());
            }
            return this;
        }else {
            return super.div(var);
        }
    }

    @Override
    public String toString() {
        return Arrays.toString(vector);
    }

    @Override
    public void fromString(String value) {

    }

}
