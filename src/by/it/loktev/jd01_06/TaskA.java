package by.it.loktev.jd01_06;

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


    }

}
