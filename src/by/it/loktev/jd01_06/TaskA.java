package by.it.loktev.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {

    public static void main(String[] args) {

        StringBuilder sb=new StringBuilder(Data.lukomor);

        Pattern pattern=Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher=pattern.matcher(sb);
        while (matcher.find()){
            //System.out.println(matcher.group()+" "+matcher.start());
            //sb.replace(matcher.start()+3,matcher.start()+4,"#");
            sb.setCharAt(matcher.start()+3,'#');
            if (matcher.group().length()>=7)
                sb.setCharAt(matcher.start()+6,'#');
                //sb.replace(matcher.start()+6,matcher.start()+7,"#");
        }
        System.out.println(sb);

        String [] word=Data.lukomor.split("[^а-яА-ЯёЁ]+");
        System.out.println(Arrays.toString(word));

        while ( word.length>0 ) {
            String[] word2 = new String[word.length];
            int word2len = 0;
            String currWord=word[0];
            int wordCount=1;
            for (int i2=1; i2<word.length; i2++) {
                if (currWord.equalsIgnoreCase(word[i2]))
                    wordCount++;
                else
                    word2[word2len++] = word[i2];
            }
            System.out.println("слово "+currWord+" встречается "+wordCount);
            //System.out.println(Arrays.toString(word2));
            //break;
            word=new String[word2len];
            for (int i = 0; i <word2len ; i++) {
                word[i]=word2[i];
            }
        }


    }

}
