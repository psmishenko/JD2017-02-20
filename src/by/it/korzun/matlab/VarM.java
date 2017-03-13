package by.it.korzun.matlab;

public class VarM extends Var{
    private double[][] matrix;

    VarM(String[][] matrix) {
        this.matrix = new double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                this.matrix[i][j] = Double.parseDouble(matrix[i][j]);
            }
        }
    }

    @Override
    public Var add(Var var) {
        if(var instanceof  VarF){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] += Double.parseDouble(var.toString());
                }
            }
            return this;
        }else if(var instanceof VarM){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] += ((VarM) var).matrix[i][j];
                }
            }
            return this;
        }
        else{
            return (var.add(this));
        }
    }

    @Override
    public Var sub(Var var) {
        if(var instanceof VarM){
            for (int i = 0; i < this.matrix.length; i++) {
                for (int j = 0; j < this.matrix[i].length; j++) {
                    this.matrix[i][j] -= ((VarM) var).matrix[i][j];
                }
            }
            return this;
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
    public Var mul(Var var) {
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
    public Var div(Var var) {
        return super.div(var);
    }

    @Override
    public void fromString(String value) {

    }

    @Override
    public String toString() {
        String str = "";
        for (double[] aMatrix : matrix) {
            for (int j = 0; j < matrix[0].length; j++) {
                str += aMatrix[j] + " ";
            }
            str += "\n";
        }
        return str;
    }
}
