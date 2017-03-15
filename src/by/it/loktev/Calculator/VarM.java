package by.it.loktev.Calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarM extends Var {

    static public String matrixRE=" *\\{ *(" + VarV.vectorRE + ",)* *" + VarV.vectorRE + "\\} *";

    static Boolean canFromString(String str){
        Pattern p = Pattern.compile("^"+matrixRE+"$");
        Matcher m = p.matcher(str);
        return m.matches();
    }

    double [] [] value;
    int rows;
    int cols;

    public VarM(String str) {
        fromString(str);
    }

    public VarM(double [] [] values){
        this.rows=values.length;
        this.cols=(this.rows>0)?(values[0].length):0;
        this.value=new double[this.rows][this.cols];
        for (int r = 0; r < this.rows; r++) {
            if (this.cols!=values[r].length)
            {
                new CalculatorError("недопустимый двумерный массив для преобразования в матрицу (строки разной длины)");
                return;
            }
            System.arraycopy(values[r],0,this.value[r],0,this.cols);
        }
    }

    @Override
    public void fromString(String str) {
        // ожидаем строку вида {{55.2,3.3},{5,7}}

        // обрезаем не только фигурные скобки самой матрицы, но и самую левую и самую правую фигурные скобки от строк, чтобы дальше было проще разделять по },{
        Pattern p = Pattern.compile("^ *\\{ *\\{ *([\\{\\}\\-\\+\\d\\., ]*) *\\} *\\} *$");
        Matcher m = p.matcher(str);
        if ( !m.matches() ) {
            new CalculatorError(str + " - недопустимое значение для преобразования в матрицу");
            return;
        }
        String rowsStr=m.group(1);
        //System.out.println(rowsStr);

        String [] rowsArr=rowsStr.split(" *\\} *, *\\{ *");
        //System.out.println(Arrays.toString(rowsArr));

        this.rows=rowsArr.length;
        Boolean colsSet=false;

        String doubleRE=" *\\d+(?:\\.\\d*)? *";
        p = Pattern.compile("^"+doubleRE+"$");

        for ( int r=0; r<this.rows; r++ ) {
            String rowStr=rowsArr[r];
            //System.out.println(rowStr);

            // разбиваем запятыми
            String [] valuesArr=rowStr.split(" *, *");

            if (!colsSet) {
                this.cols=valuesArr.length;
              colsSet=true;
              value=new double[this.rows][this.cols];
            }
            else
                if (this.cols!=valuesArr.length) {
                    new CalculatorError(str + " - недопустимое значение для преобразования в матрицу (строки разной длины)");
                    return;
                }

            for ( int c=0; c<this.cols; c++ )
            {
                String valueStr=valuesArr[c];
                m = p.matcher(valueStr);
                if ( !m.matches() ) {
                    new CalculatorError(valueStr + " - недопустимое значение для преобразования в число");
                    return;
                }
                this.value[r][c]=Double.parseDouble(m.group());
            }

        }

    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        sb.append("{");
        for ( int r=0; r<this.rows; r++ ) {
            if ( r>0 )
                sb.append(",");
            sb.append("{");
            for ( int c=0; c<this.cols; c++ )
            {
                if ( c>0 )
                    sb.append(",");
                sb.append(this.value[r][c]);
            }
            sb.append("}");
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var mul(Var arg) {
        if ( arg instanceof VarF ){
            VarF varF=(VarF)arg;
            double [] [] res=new double[this.rows][this.cols];
            for (int r = 0; r < this.rows; r++) {
                for (int c = 0; c <this.cols; c++) {
                  res[r][c]=this.value[r][c]*varF.value;
                }
            }
            return new VarM(res);
        }
        return super.mul(arg);
    }

    /*
    public static double [] arrayMulVector(double [] [] x, double [] y){
        double [] z=new double[x.length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y.length; j++)
                z[i]+=x[i][j]*y[j];
        return z;
    }

    public static double [] [] arrayMulVector(double [] [] x, double [] [] y){
        double [] [] z=new double[x.length][y[0].length];
        for (int i=0; i<x.length; i++)
            for (int j=0; j<y[0].length; j++)
                for (int k=0; k<y.length; k++)
                    z[i][j]+=x[i][k]*y[k][j];
        return z;
    }
    */

}
