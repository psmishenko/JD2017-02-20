package by.it.psmishenko.matlab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var{
    public Double[][] matrix;


// operations +-*/
    @Override
    public Var add(Var var) {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] + ((VarF) var).value;
                }
            }
        }//else if(var instanceof VarM ){}  реализовать сложение матриц (одинак. размерность)
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var sub(Var var) {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] - ((VarF) var).value;
                }
            }
        } //else if(var instanceof VarM ){}  реализовать вычитание матриц (одинак. размерность)
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var mul(Var var) {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] * ((VarF) var).value;
                }
            }
        } //else if(var instanceof VarM ){}  реализовать умножение матриц
        //else if(var instanceof VarV ){}  реализовать умножение матрицы на вектор
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var div(Var var) {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] / ((VarF) var).value;
                }
            }
        } else return super.add(var);
        return new VarM(res);
    }
// constructors

    public VarM(Double[][] matrix) {
        this.matrix = new Double[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            System.arraycopy(matrix[i], 0, this.matrix[i], 0, matrix[0].length);
        }
    }

    public VarM(VarM copyFrom) {
        matrix = new Double[copyFrom.matrix.length][copyFrom.matrix[0].length];
        for (int i = 0; i <copyFrom.matrix.length ; i++) {
            System.arraycopy(copyFrom.matrix[i],0,matrix[i],0,copyFrom.matrix[0].length);
        }
    }

    public VarM(String str) {
        fromString(str);
    }

    @Override
    public void fromString(String str) {
        Pattern p = Pattern.compile(Patterns.exMat);
        if (p.matcher(str).matches()) {
            p = Pattern.compile(Patterns.exVal);
            Pattern p2 = Pattern.compile(Patterns.exVec);
            Matcher m2 = p2.matcher(str);
            int k =0; int l =0;
            while (m2.find()) k++;
            m2.reset(); m2.find();
            String s = m2.group();
            Matcher m3 = p.matcher(s);
            while (m3.find()) l++;
            matrix = new Double[k][l];
            Matcher m = p.matcher(str);
            for (int i = 0; i <k ; i++) {
                for (int j = 0; j <l ; j++) {
                    m.find();
                    String oneValue = m.group();
                    matrix[i][j] = Double.parseDouble(oneValue);
                }
            }
        }else new Error("Ошибка: " + str + "  не является матрицей");
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[0].length ; j++) {
                if(j==0) sb.append("{");
                sb.append(matrix[i][j].toString());
               if(j!=matrix[0].length-1) sb.append(",");
            }
            sb.append("}");
            if(i!=matrix.length-1) sb.append(",");
        }
        sb.append("}");
        return sb.toString();
    }
}
