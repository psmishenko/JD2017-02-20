package by.it.korzun.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static void run(){
        System.out.println("TaskC:\n1.------------------------------------------");
        String str = Data.lukomor;

        String []massLinesStr = str.split("\\n");
        StringBuilder []massLinesStrB = new StringBuilder[massLinesStr.length];
        int maxLength = Integer.MIN_VALUE;
        for (int i = 0; i < massLinesStr.length; i++) {
            massLinesStrB[i] = new StringBuilder(massLinesStr[i]);
            if(massLinesStr[i].length() > maxLength){
                maxLength = massLinesStr[i].length();
            }
        }

        Pattern pattern = Pattern.compile(" ");
        Matcher matcher;
        int [] spacesCount = new int[massLinesStrB.length];
        for (int i = 0; i < massLinesStrB.length; i++) {
            matcher = pattern.matcher(massLinesStrB[i]);
            while(matcher.find()){
                spacesCount[i]++;
            }
        }

        for (int i = 0; i < massLinesStrB.length; i++) {
            double spacesToAdd = (double)(maxLength - massLinesStrB[i].length()) / (double)spacesCount[i];
            matcher = pattern.matcher(massLinesStr[i]);
            String strRepl = "";
            int k = 0;
            while(k <= spacesToAdd){
                strRepl = strRepl.concat(" ");
                k++;
            }
            massLinesStr[i] = matcher.replaceAll(strRepl);

            massLinesStrB[i] = new StringBuilder(massLinesStr[i]);
            matcher = pattern.matcher(massLinesStrB[i]);
            if(massLinesStrB[i].length() < maxLength){
                int length = massLinesStrB[i].length();
                while(length != maxLength){
                    if(matcher.find()) {
                        massLinesStrB[i] = massLinesStrB[i].insert(matcher.start(), " ");
                        length++;
                    }
                }
            }
        }
        for (StringBuilder aMassLinesStrB : massLinesStrB) {
            System.out.println(aMassLinesStrB.length() + " " + aMassLinesStrB);
        }

        System.out.println("2.------------------------------------------");
        str = str.replaceAll("\\p{Cntrl}", " ");
        String []allWords = str.split("[ ,;:.-]");
        int k = 0;
        long startTime = System.currentTimeMillis();
        String oneMillSymbStr = "";
        while(k != 1119) {
            for (String allWord : allWords) {
                oneMillSymbStr = oneMillSymbStr.concat(allWord + " ");
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
            for (StringBuilder anAllWordsSb : allWordsSb) {
                oneMillSymbStrSb.append(anAllWordsSb).append(" ");
            }
            k++;
        }
        for (int i = 0; i < allWords.length - 40; i++) {
            oneMillSymbStrSb.append(allWordsSb[i]).append(" ");
        }
        resultTime = System.currentTimeMillis() - startTime;
        System.out.println("Длина StringBuilder: " + oneMillSymbStrSb.length() + "\nВремя работы со StringBuilder: " + resultTime);

    }
}
