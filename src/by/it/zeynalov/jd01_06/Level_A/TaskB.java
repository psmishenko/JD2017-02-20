package by.it.zeynalov.jd01_06.Level_A;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.zeynalov.jd01_06.Level_A.Data.lukomor;


public class TaskB {

    //отдельный метод для нахождения в тексте слов начинающихся и заканчивающихся на гласные буквы
    public static void stix() {
        String[] words = lukomor.split("[\\n\\s\\p{Punct}]");
        Pattern pattern = Pattern.compile("([аеиояуюыэ])(.*[аеиояуюыэ])?", Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);
        for (String o : words)
            if (pattern.matcher(o).matches()) System.out.println(o);
    //метод на возрастание количества слов
        String[] l = lukomor.replace("...", "").replace("\n", " ").split("[.]");
        //Arrays.sort(l, (o1, o2) -> o1.split("[^а-яА-ЯёЁ]+").length - o2.split("[^а-яА-ЯёЁ]+").length);
        for (int i = 0; i < l.length; i++)
            System.out.println(l[i]);

    }

}
