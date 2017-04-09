package by.it.radivonik.calculator;

import java.util.Locale;
import java.util.regex.*;

/**
 * Created by Radivonik on 17.03.2017.
 */
public class VarMatrix extends Var {
    private double[][] matrix;

    // Конструкторы
    public VarMatrix(double[][] matrix) throws ParseException {
        matrixCopy(matrix);
    }

    public VarMatrix(VarMatrix var) throws ParseException {
        matrixCopy(var.matrix);
    }

    public VarMatrix(String str) throws ParseException {
        fromString(str);
    }

    private void matrixCopy(double[][] matrix) throws ParseException {
        this.matrix = new double[matrix.length][matrix.length > 0 ? matrix[0].length : 0];
        for (int i = 0; i < rowCount(); i++) {
            if (colCount() != matrix[i].length)
                throw new ParseException("Невозможно создать матрицу (строки разной длины)");
            System.arraycopy(matrix[i],0,this.matrix[i],0,colCount());
        }
    }

    @Override
    public void fromString(String str) throws ParseException {
        Pattern p = Pattern.compile(IPatterns.ExMatrix);
        if (p.matcher(str).matches()) {
            Pattern pVec = Pattern.compile(IPatterns.ExVector);
            Pattern pNum = Pattern.compile(IPatterns.ExNumber);

            Matcher mVec = pVec.matcher(str);
            Matcher mNum;

            int rowCount = 0;
            int colCount = 0;
            while (mVec.find()) {
                mNum = pNum.matcher(mVec.group());
                if (rowCount == 0)
                    while (mNum.find()) colCount++;
                rowCount++;
            }

            matrix = new double[rowCount][colCount];
            mVec.reset();

            int row = 0;
            int col;
            while (mVec.find()) {
                col = 0;
                mNum = pNum.matcher(mVec.group());
                while (mNum.find()) {
                    matrix[row][col] = Double.parseDouble(mNum.group());
                    col++;
                }
                ;
                row++;
            }
        }
        else {
            throw new ParseException(str + " не является матрицей");
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder("{");
        String delim = "";
        for (int i = 0; i < rowCount(); i++) {
            res.append(delim);
            res.append(new VarVector(matrix[i]).toString());
            delim = ",";
        }
        res.append("}");
        return res.toString();
    }

    public int rowCount() {
        return matrix.length;
    }

    public int colCount() {
        return matrix.length > 0 ? matrix[0].length : 0;
    }

    public double getItem(int row, int col) {
        return matrix[row][col];
    }
}
