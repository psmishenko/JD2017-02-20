package by.it.prigozhanov.my_matlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 4/13/2017!
 */
public class VarMatrix extends Var {
    Double[][] matrix;

    @Override
    public Var add(Var var) throws MatlabException {

        return super.add(var);
    }

    @Override
    public Var sub(Var var) throws MatlabException {
        return super.sub(var);
    }

    @Override
    public Var div(Var var) throws MatlabException {
        return super.div(var);
    }

    @Override
    public Var mul(Var var) throws MatlabException {
        if (var instanceof VarVector) {
            VarVector vector = (VarVector) var;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    vector.vector[i]+=(matrix[i][j]*vector.vector[i]);
                }
            }
            return new VarVector(vector);
        } else
            return super.mul(var);
    }

    public VarMatrix(String matrix) {
        fromString(matrix);
    }

    public VarMatrix(VarMatrix var) {
    }

    public VarMatrix(Double[][] matrix) {

    }

    @Override
    public void fromString(String stringValue) {
        Pattern patternVec = Pattern.compile(Expressions.VECTOR);
        Pattern patternVal = Pattern.compile(Expressions.VALUE);
        Matcher matcher = patternVec.matcher(stringValue);
        int line = 0;
        int pos = 0;
        int height = 0;
        int width = 0;
        boolean lenChecked = false;
        while (matcher.find()) {
            Matcher matcherValue = patternVal.matcher(matcher.group());
            height++;
            while (matcherValue.find() && !lenChecked) {
                width++;
            }
            lenChecked = true;
        }
        this.matrix = new Double[height][width];
        matcher.reset();
        while (matcher.find()) {
            String vector = matcher.group();
            Matcher matcherValue = patternVal.matcher(vector);
            while (matcherValue.find()) {
                this.matrix[line][pos] = Double.parseDouble(matcherValue.group());
                pos++;
            }
            pos = 0;
            line++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < matrix.length; i++) {
            sb.append("{");
            for (int j = 0; j < matrix[0].length; j++) {
                sb.append(matrix[i][j]);
                if (j + 1 != matrix[0].length) {
                    sb.append(",");
                }
            }
            sb.append("}");
            if (i + 1 != matrix.length) {
                sb.append(",");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
