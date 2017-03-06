package by.it.korzun.jd01_06;


import java.math.BigDecimal;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static void run(){
        String str = Data.lukomor;

        //Не работающий С1
        String []massLinesStr = str.split("\\n");
        StringBuilder []massLinesStrB = new StringBuilder[massLinesStr.length];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < massLinesStr.length; i++) {
            massLinesStrB[i] = new StringBuilder(massLinesStr[i]);
            if(massLinesStr[i].length() > maxLength){
                maxLength = massLinesStr[i].length();
            }
        }
        System.out.println(maxLength);

        Pattern pattern = Pattern.compile("\\s");
        Matcher matcher;
        int [] spacesCount = new int[massLinesStrB.length];
        for (int i = 0; i < massLinesStrB.length; i++) {
            matcher = pattern.matcher(massLinesStrB[i]);
            while(matcher.find()){
                spacesCount[i]++;
            }
        }

        for (int i = 0; i < massLinesStrB.length; i++) {
            double spacesToAdd = Math.ceil((double)(maxLength - massLinesStrB[i].length()) / (double)spacesCount[i]);
            matcher = pattern.matcher(massLinesStrB[i]);
            while(matcher.find()){
                int j = 1;
                while(j <= spacesToAdd){
                    massLinesStrB[i].insert(matcher.start(), " ");
                    j++;
                }
                for (int k = 0; k < spacesToAdd; k++) {
                    matcher.find();
                }
            }
//            if(spacesToAdd % (int)spacesToAdd != 0){
//                massLinesStrB[i].insert(matcher.start(), " ");
//            }
        }
        for (int i = 0; i < massLinesStrB.length; i++) {
            System.out.println(massLinesStrB[i]);
        }

        //C2
        System.out.println("C2:");
        str = str.replaceAll("\\p{Cntrl}", " ");
        String []allWords = str.split("[ ,;:.-]");
        int k = 0;
        long startTime = System.currentTimeMillis();
        String oneMillSymbStr = new String();
        while(k != 1119) {
            for (int i = 0; i < allWords.length; i++) {
                oneMillSymbStr = oneMillSymbStr.concat(allWords[i] + " ");
            }
            System.out.println("Выполнено: " + k + " из 1119");
            k++;
        }
        for (int i = 0; i < allWords.length - 40; i++) {
            oneMillSymbStr = oneMillSymbStr.concat(allWords[i] + " ");
        }
        long resultTime = System.currentTimeMillis() - startTime;
        System.out.println("Длина String: " + oneMillSymbStr.length() + "\nВремя работы со String: " + resultTime);

        StringBuilder []allWordsSb = new StringBuilder[allWords.length];
        for (int i = 0; i < allWords.length; i++) {
            allWordsSb[i] = new StringBuilder(allWords[i]);
        }

        startTime = System.currentTimeMillis();
        StringBuilder oneMillSymbStrSb = new StringBuilder();
        oneMillSymbStrSb.ensureCapacity(1000000);
        k = 0;
        while(k != 1119) {
            for (int i = 0; i < allWordsSb.length; i++) {
                oneMillSymbStrSb.append(allWordsSb[i] + " ");
            }
            k++;
        }
        for (int i = 0; i < allWords.length - 40; i++) {
            oneMillSymbStrSb.append(allWordsSb[i] + " ");
        }
        resultTime = System.currentTimeMillis() - startTime;
        System.out.println("Длина StringBuilder: " + oneMillSymbStrSb.length() + "\nВремя работы со StringBuilder: " + resultTime);

    }
}
