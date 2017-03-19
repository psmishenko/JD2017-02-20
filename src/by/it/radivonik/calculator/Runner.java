package by.it.radivonik.calculator;

import java.util.regex.*;

/**
 * Created by Radivonik on 19.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        String s = "{-2.5,3.6,5},{4,-5,0}";
        Pattern p = Pattern.compile(IPatterns.ExVector);
        Matcher m = p.matcher(s);
        while (m.find()) {
            System.out.println(m.group());
            System.out.println(m.groupCount());
            for (int i = 0; i < m.groupCount(); i++) {
                System.out.println(m.group(i));
            }
        }
    }
}
