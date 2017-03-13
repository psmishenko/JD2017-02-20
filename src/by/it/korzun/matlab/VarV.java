package by.it.korzun.matlab;

import java.util.Arrays;

public class VarV extends Var{
    public double []vector;

    VarV() {
    }

    VarV(String[] value) {
        vector = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            vector[i] = Double.parseDouble(value[i]);
        }
    }

    @Override
    public Var add(Var var) {
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] += Double.parseDouble(var.toString());
            }
            return this;
        }else if(var instanceof VarV){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] += ((VarV) var).vector[i];
            }
            return this;
        }
        else{
            return (var.add(this));
        }
    }

    @Override
    public Var sub(Var var) {
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] -= Double.parseDouble(var.toString());
            }
            return this;
        }
        else if(var instanceof VarV){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] -= ((VarV) var).vector[i];
            }
            return this;
        }else {
            return super.sub(var);
        }
    }
    @Override
    public Var mul(Var var) {
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] *= Double.parseDouble(var.toString());
            }
            return this;
        }
        else if(var instanceof VarV){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] *= ((VarV) var).vector[i];
            }
            return this;
        }else {
            return (var.add(this));
        }
    }
    @Override
    public Var div(Var var) {
        if(var instanceof  VarF){
            for (int i = 0; i < this.vector.length; i++) {
                this.vector[i] /= Double.parseDouble(var.toString());
            }
            return this;
        }else {
            return super.sub(var);
        }
    }

    @Override
    public String toString() {
        return "VarV{" +
                "vector=" + Arrays.toString(vector) +
                '}';
    }

    @Override
    public void fromString(String value) {

    }

}
