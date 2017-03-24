package by.it.loktev.jd01_14;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TaskB {

    public static void taskB() {

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_14/";
        String fileName=basePath+"taskB.txt";

        try (
                FileReader fr = new FileReader(fileName);
                BufferedReader bo = new BufferedReader(fr);
        ) {

            StringBuffer sb=new StringBuffer();
            while ( bo.ready() ){
                sb.append(bo.readLine()+"\n");
            }
            System.out.println(sb);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
