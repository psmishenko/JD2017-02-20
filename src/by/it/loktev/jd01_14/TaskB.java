package by.it.loktev.jd01_14;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class TaskB {

    public static void taskB() {

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_14/";
        String fileName=basePath+"taskB.txt";

        StringBuffer sb=new StringBuffer();

        try (
            FileReader fr = new FileReader(fileName);
            BufferedReader bo = new BufferedReader(fr);
        ) {
            while ( bo.ready() ){
                sb.append(bo.readLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String commaRE="[,.!?;-]";
        int countComma=(" "+sb.toString()+" ").split(commaRE).length-1;
        String wordRE="[а-яА-ЯёЁ]+";
        int countWord=(" "+sb.toString()+" ").split(wordRE).length-1;
        System.out.println("Знаков препинания: "+countComma);
        System.out.println("Слов: "+countWord);

    }

}
