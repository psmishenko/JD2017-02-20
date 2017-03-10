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
        System.out.println(maxSymbols);
        Pattern pattern2 = Pattern.compile("[ ]+");
        lastPos =0;
        matcher1.reset();
        while (matcher1.find()) {
            currentLength = matcher1.start() - lastPos;
            int numOfSpaces = maxSymbols - currentLength;
            if(maxSymbols>currentLength) {
                int k = 0;
                Matcher matcher2 = pattern2.matcher(sb.substring(lastPos, matcher1.start()));
                while (matcher2.find()) k++;
                matcher2.reset();
                int buf = numOfSpaces;
                int z=k;
                while (matcher2.find()) {
                    System.out.println(matcher2.start());
                    do {
                        sb.insert(matcher2.start()," ");
                        buf--;
                        z--;
                        if(z==0) {
                            matcher2.reset();
                            z=k;
                        }
                    } while (buf > 0);
                }
            }
            lastPos = matcher1.end()+numOfSpaces;
            matcher1.find();
        }
        System.out.println(sb.toString());
    }
}
