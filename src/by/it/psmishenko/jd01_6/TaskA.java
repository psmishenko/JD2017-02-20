package by.it.psmishenko.jd01_6;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA {
    static void replaceSymbols (StringBuilder sb) {
        System.out.println("#1. Замена 3ей и 7ой буквы на #");
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]{4,}");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            int pos = matcher.start()+3;
            sb.setCharAt(pos,'#');
            if(matcher.group().length()>6){
                pos = matcher.start()+6;
                sb.setCharAt(pos,'#');
            }
        }
        System.out.println(sb.toString());
    }
    static void numberOfRep (){
        System.out.println("---------------------------\n#2. Определение кол-ва повторов слова в тексте ");
        String[] words = Data.lukomor.split("[^а-яА-ЯёЁ]+");
        for (int i = 0; i <words.length ; i++) {
            String word = words[i];
            int counter = 0;
            if(!word.isEmpty()){
                for (int j = i+1; j <words.length ; j++) {
                    if (word.equalsIgnoreCase(words[j])) {
                        counter++;
                        words[j] = "";

                    }
                }
                if(counter>1)  System.out.printf("слово %2$s повторяется %1$d раз\n",counter,word);
            }
        }
    }
}
