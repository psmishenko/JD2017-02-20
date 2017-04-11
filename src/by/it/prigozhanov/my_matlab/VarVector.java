package by.it.prigozhanov.my_matlab;

/**
 * Created by v-omf on 4/12/2017.
 *
 * @author v-omf
 */
public class VarVector extends Var {
    private double[] values;

    private boolean isLenghEquals(VarVector varVector1, VarVector varVector2) {
        if (varVector1.values.length == varVector2.values.length) return true;
        else return false;
    }

    public VarVector(double[] values) {
        this.values = values;
    }

    public VarVector(String stringVector) {

    }


    @Override
    public Var plus(Var var) {
        return super.plus(var);
    }

    @Override
    public Var minus(Var var) {
        return super.minus(var);
    }

    @Override
    public Var div(Var var) {
        return super.div(var);
    }

    @Override
    public Var mul(Var var) {
        return super.mul(var);
    }

    @Override
    public String toString() {
        StringBuilder vector = new StringBuilder("{");
        for (int i = 0; i < this.values.length; i++) {
            vector.append(this.values[i]);
            if (i+1 != this.values.length) vector.append(",");
        }
        vector.append("}");
        return vector.toString();
    }

    @Override
    public void fromString(String stringValue) {

    }
}
