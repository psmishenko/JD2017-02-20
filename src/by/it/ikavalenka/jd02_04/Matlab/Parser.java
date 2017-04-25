package by.it.ikavalenka.jd02_04.Matlab;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    public static void pars(String s) throws ErrorException, NullPointerException, ArrayIndexOutOfBoundsException {

        String operationPlusResult = null;
        while (s.contains("(")&&s.contains(")")){

            Pattern pat = Pattern.compile("\\([ \\w\\.\\+\\-\\*\\/\\[\\]\\{\\},]+\\)");
            Matcher mat = pat.matcher(s);

            mat.find();
            //System.out.println(mat.group());
            String groupNoBraces = mat.group().replace("(", "");
            groupNoBraces = groupNoBraces.replace(")", "");
            //System.out.println(groupNoBraces);
            String[] arrayFromGroup = UtilsMatlab.convertLineToArray(groupNoBraces, Patterns.operationType);
            String result = UtilsMatlab.calculateWith2Operands(groupNoBraces,arrayFromGroup).toString();
            //System.out.println(result);
            String newLine = s.replace(mat.group(), result);
            //System.out.println(newLine);
            pars(newLine);
            break;


        }
        if (!s.contains("(")) {

            if (!s.contains("=")) {
                String[] array = UtilsMatlab.convertLineToArray(s,Patterns.operationType);

                operationPlusResult = InitialLine.getLine() + " = " + UtilsMatlab.calculateWith2Operands(s,array);
                System.out.println(operationPlusResult);

            } else {
                String varName;
                String exToCalculate;

                String[] arrayWithVarName = UtilsMatlab.convertLineToArray(s,"=");
                varName = arrayWithVarName[0].trim();
                exToCalculate = arrayWithVarName[1].trim();

                String [] array = UtilsMatlab.convertLineToArray(exToCalculate,Patterns.operationType);
                Var var = UtilsMatlab.calculateWith2Operands(exToCalculate,array);
                if (var!=null) {
                    MapVariables.addVariable(varName, var);
                    System.out.println("Операция присваивания выполнена.");
                }
                operationPlusResult = InitialLine.getLine() +" = "+var;
                System.out.println(operationPlusResult);

            }

        }
        synchronized (QueueOperationsForReport.getQueueOperationsForReport()){
            QueueOperationsForReport.addOperation(operationPlusResult);
            QueueOperationsForReport.getQueueOperationsForReport().notifyAll();

        }

    }
}
