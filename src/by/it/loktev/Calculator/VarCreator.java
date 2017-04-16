package by.it.loktev.Calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class VarCreator {

    private static VarCreator instance;

    private VarCreator(){

    }

    public static VarCreator getInstance(){
        if (instance==null){
            instance=new VarCreator();
        }
        return instance;
    }

    Var create(String exprSB){

        try {

            // в выражении может идти литерал матрицы - VarM
            Pattern pattVarM = Pattern.compile("^" + VarM.matrixRE);
            Matcher matchVarM = pattVarM.matcher(exprSB);
            if (matchVarM.find()) {
                String literal = matchVarM.group();
                VarM varM = new VarM(literal);
                return varM;
            }

            // в выражении может идти литерал вектора - VarV
            Pattern pattVarV = Pattern.compile("^" + VarV.vectorRE);
            Matcher matchVarV = pattVarV.matcher(exprSB);
            if (matchVarV.find()) {
                String literal = matchVarV.group();
                VarV varV = new VarV(literal);
                return varV;
            }

            // в выражении может идти литерал числа - VarF
            Pattern pattVarF = Pattern.compile("^" + VarF.doubleRE);
            Matcher matchVarF = pattVarF.matcher(exprSB);
            if (matchVarF.find()) {
                String literal = matchVarF.group();
                VarF varF = new VarF(literal);
                return varF;
            }

        }catch ( CalculatorException e ){
            return null;
        }

        return null;
    }

}
