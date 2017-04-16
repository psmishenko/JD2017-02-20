package by.it.smirnov.jd02_06_matlab.BuilderReport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

/**
 * Класс вспомогательных функций
 */
public class Helper {
    public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

    /**
     * Деление строк на подстроки в соответствии с указанной длиной
     * @param countChar длина
     * @param str строка
     * @return ArrayList строк
     */
    public static ArrayList<String> getStrPart(int countChar, String str) {
        ArrayList<String> arrResult = new ArrayList<>();
        if (str!=null) {
            String arrLines[] = str.split("\n");
            for (String line: arrLines) {
                arrResult.addAll(getSubStrPart(countChar, line));
            }
        }
        return arrResult;
    }
    private static ArrayList<String> getSubStrPart(int countChar, String str) {
        String arrWords[] = str.split(" ");
        ArrayList<String> arrPhrases = new ArrayList<String>();

        StringBuilder stringBuffer = new StringBuilder();
        int cnt = 0;
        int index = 0;
        int length = arrWords.length;

        while (index != length) {
            if (cnt + arrWords[index].length() <= countChar) {
                cnt += arrWords[index].length() + 1;
                stringBuffer.append(arrWords[index]).append(" ");
                index++;
            } else {
                arrPhrases.add(stringBuffer.toString());
                stringBuffer = new StringBuilder();
                cnt = 0;
            }

        }

        if (stringBuffer.length() > 0) {
            arrPhrases.add(stringBuffer.toString());
        }
        return arrPhrases;
    }

}
