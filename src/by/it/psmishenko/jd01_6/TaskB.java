package by.it.psmishenko.jd01_6;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    static void firstAndLastVowel (StringBuilder sb){
        System.out.println("---------------------------\n#3.Определение количества слов с гласными в конце и начале");
        Pattern pattern1 = Pattern.compile("[а-яА-ЯёЁ]{3,}");
        Pattern pattern2 = Pattern.compile("[аАеЕёЁуУыЫоОэЭяЯиИюЮ]{2}");
        Matcher matcher1 = pattern1.matcher(sb);
        int с=0;
        while (matcher1.find()){
            int firstL = matcher1.start();
            int lastL = matcher1.end()-1;
           String s =  sb.substring(firstL,firstL+1)+sb.substring(lastL,lastL+1);
           Matcher matcher2 = pattern2.matcher(s);
           if(matcher2.matches()) {
               System.out.printf("Слово <%s> начинается и заканчивается на гласную букву.\n",sb.substring(firstL,lastL+1));
               с++;
           }
        }
        System.out.println("Количество слов, начинающихся и заканчивающихся на гласную - "+с);
    }
    static void newPosition (StringBuilder sb){
        System.out.println("---------------------------\n#4.Вывод текста в порядке возрастания кол-ва слов");
        Pattern pattern = Pattern.compile("[\n]");
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) sb.replace(matcher.start(), matcher.end()," ");
        String[] sentence = sb.toString().split("[.;:!]+");
        Pattern patternBuf = Pattern.compile("[а-яА-ЯёЁ]+");
        for (int i = 0; i <sentence.length-1 ; i++) {
            for (int j = i+1; j <sentence.length; j++) {
                int counterI = 0; int counterJ = 0;
              Matcher matcherBuf1 = patternBuf.matcher(sentence[i]);
              while (matcherBuf1.find()) counterI++;
              Matcher matcherBuf2 = patternBuf.matcher(sentence[j]);
              while (matcherBuf2.find()) counterJ++;
              if(counterJ>counterI){
                  String buf = sentence[j];
                  sentence[j] = sentence[i];
                  sentence[i] = buf;
              }
            }
        }
        for (int i = 0; i <sentence.length ; i++) {
            System.out.println(sentence[i]);
        }
    }
}
