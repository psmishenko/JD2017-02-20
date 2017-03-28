package by.it.korzun.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    void run(){
        String path = System.getProperty("user.dir") + "/src/by/it/korzun/jd01_15/";
        //comment
        List<StringBuilder> sb = new ArrayList<>();//another comment
        Pattern pattern = Pattern.compile("((^\\//)|([\\s;{)(]//))");
        Matcher matcher;
//third comment
        try(BufferedReader br = new BufferedReader(new FileReader(path + "TaskB.java"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + "TaskB.txt"))){
            String temp;
            while((temp = br.readLine()) != null) {//forth comment
                StringBuilder tempSB = new StringBuilder();

                tempSB.append(temp);
                sb.add(tempSB);

            }

            int k = 0;
            for (Iterator<StringBuilder> it = sb.iterator(); it.hasNext();k++) {
                matcher = pattern.matcher(it.next());
                if(matcher.find()){
                    if(sb.get(k).charAt(matcher.start()) == '/') {
                        sb.get(k).replace(matcher.start(), sb.get(k).length(), "");
                    }else{
                        sb.get(k).replace(matcher.start() + 1, sb.get(k).length(), "");
                    }
                }

            }

            for (int i = 0; i < sb.size(); i++) {
                byte []bytes = sb.get(i).toString().getBytes();
                System.out.print((i + 1) + ": ");
                for (byte aByte : bytes) {
                    System.out.print(aByte + " ");
                }
                System.out.println();

                bos.write(((i + 1) + ": " + sb.get(i) + "\n").getBytes());
            }
        }catch (IOException e){

        }
    }
}
