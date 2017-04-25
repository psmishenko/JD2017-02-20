package by.it.ikavalenka.jd02_04.Matlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatrixCreator extends Creator {

    @Override
    public Var create(String s, int lineQuantity) {

        Pattern pat1 = Pattern.compile(Patterns.number);
        Matcher mat1 = pat1.matcher(s);
        int numQuantity = 0;
        while (mat1.find()){
            numQuantity++;
        }

        mat1.reset();

        float [][] array = new float[lineQuantity][numQuantity/lineQuantity];
        for (int i = 0; i < lineQuantity; i++) {
            for (int j = 0; j < numQuantity/lineQuantity; j++) {
                if (mat1.find()) {
                    array[i][j] = Float.parseFloat(mat1.group());
                }
            }
        }
        return new MatrixVar(array);
    }
}
