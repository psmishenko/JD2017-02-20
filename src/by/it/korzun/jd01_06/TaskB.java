package by.it.korzun.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static int checkGlasn(String[] words){
        Pattern patternLong = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯ](.)*[аеёиоуыэюяАЕЁИОУЫЭЮЯ]");
        Pattern patternOne = Pattern.compile("[аеёиоуыэюяАЕЁИОУЫЭЮЯ]");
        Matcher matcher;
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if(words[i].length() > 1) {
                matcher = patternLong.matcher(words[i]);
            }else{
                matcher = patternOne.matcher(words[i]);
            }
            if(matcher.matches()){
                //System.out.println(words[i]);
                count++;
            }
        }
        return count;
    }
    static void run(){
        String[] words = Data.lukomor.split("[^а-яА-ЯеЁ]+");
        System.out.println("B1: " + checkGlasn(words));

        System.out.println("B2:");
        String s = new String(Data.lukomor);
        s = s.replaceAll("\\p{Cntrl}", " ");
        String[] sentences = s.split("[.!?;]");

        sentences = Util06.sort(sentences);
        for (String sk:sentences) {
            sk = sk.trim();
            System.out.println(sk);
        }
    }
}
