package by.it.psmishenko.matlab;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var{
    public Double[][] matrix;
    private void checkSize(VarM m1, VarM m2)throws MathException{
        if(m1.matrix.length!=m2.matrix.length||m1.matrix[0].length!=m2.matrix[0].length){
            throw new MathException("Разный размер у матриц");
        }
    }

// operations +-*/
    @Override
    public Var add(Var var) throws MathException {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] + ((VarF) var).value;
                }
            }
        }else if(var instanceof VarM ) {
            checkSize(this, (VarM) var);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = matrix[i][j] + ((VarM) var).matrix[i][j];
                }
            }
        }
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var sub(Var var) throws MathException {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] - ((VarF) var).value;
                }
            }
        } else if(var instanceof VarM ){
            checkSize(this, (VarM) var);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = matrix[i][j] - ((VarM) var).matrix[i][j];
                }
            }
        }
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var mul(Var var) throws MathException {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j <res[0].length; j++) {
                    res[i][j] = matrix[i][j] * ((VarF) var).value;
                }
            }
        } else if(var instanceof VarM ){
            checkSize(this, (VarM) var);
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    Double sum = 0.0;
                    for (int k = 0; k < ((VarM) var).matrix[0].length; k++) {
                      sum += matrix[i][k] * ((VarM) var).matrix[k][j];
                        res[i][j] = sum;
                    }
                }}
        }
        else if(var instanceof VarV ){
            if(this.matrix.length!=((VarV) var).vector.length)
                throw new MathException("Число столбцов в матрице не совпадает с числом строк в векторе");
            Double[] resV = new Double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                Double sum = 0.0;
                for (int j = 0; j < ((VarV) var).vector.length; j++) {
                    sum+= matrix[i][j]*((VarV) var).vector[j];
                    resV[i] = sum;
                }}
                return new VarV(resV);
        }
        else return super.add(var);
        return new VarM(res);
    }

    @Override
    public Var div(Var var) throws MathException {
        Double[][] res = new Double[matrix.length][matrix[0].length];
        if (var instanceof VarF) {
            if(((VarF)var).value==0) throw new MathException("Деление на ноль");
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

    public VarM(String str) throws MathException {
        fromString(str);
    }

    @Override
    public void fromString(String str) throws MathException {
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
        }else throw new MathException(str + "  не является матрицей");
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
