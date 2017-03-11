package by.it.psmishenko.jd01_6;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC {
    static void alignmentLines(StringBuilder sb) {
        System.out.println("---------------------------\n#5. Выравнивание текста");
        Pattern pattern1 = Pattern.compile("[\n]+");
        Matcher matcher1 = pattern1.matcher(sb);
        // Определяем максимальную длину строки
        int currentLength; int maxSymbols = 0; int lastPos = 0;
        while (matcher1.find()){
            currentLength = matcher1.start() - lastPos;
            if(currentLength>maxSymbols) maxSymbols=currentLength;
            lastPos = matcher1.end();
        }
        System.out.println("Максимальное кол-во символов в строке - "+maxSymbols+".\n");
        Pattern pattern2 = Pattern.compile("[ ]+|[ ]{2,}");
        Matcher matcher2 = pattern2.matcher(sb);
        lastPos =0;
        matcher1.reset();
        while (matcher1.find(lastPos)) {
            currentLength = matcher1.start() - lastPos;
            int numOfSpaces = maxSymbols - currentLength;
            if(maxSymbols>currentLength) {
                int pos =lastPos;
                for (int i = 1; i <=numOfSpaces  ; i++) {
                     matcher2.find(pos);
                    if(matcher2.start()>(matcher1.start()+i)) {pos = lastPos; matcher2.find(pos);}
                    sb.insert(matcher2.start()," ");
                   if(matcher2.end()<(matcher1.start()+i)) pos = matcher2.end()+1;
                }

            }
            lastPos +=maxSymbols+1;
        }
        // Т.к. в последнем предложении нет перевода строки, делаем спец. обработку для последнего предложения
        Pattern pattern3 = Pattern.compile("\\.");
        Matcher matcher3 = pattern3.matcher(sb);
        matcher3.find(lastPos);
            currentLength = matcher3.end() - lastPos;
            int numOfSpaces = maxSymbols - currentLength;
            if (maxSymbols>currentLength){
                int pos =lastPos;
                for (int i = 1; i <=numOfSpaces  ; i++) {
                    if(!matcher2.find(pos)) {matcher2.reset(); pos = lastPos;}
                   boolean b = matcher2.find(pos);
                    sb.insert(matcher2.start()," ");
                    if(b) pos = matcher2.end()+1;
                }
            }
       System.out.println(sb.toString());
    }
}
