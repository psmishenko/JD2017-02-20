package by.it.loktev.jd01_15;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class TaskB {

    public static void taskB(){

        /* comment 1 */
        // comment 2

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_15/"; // comment
        String fileName=basePath+"TaskB.java";

        StringBuilder sb=new StringBuilder();

        /* comment 1 */
        // comment 2

        try (
                FileReader fr = new FileReader(fileName); // comment
                BufferedReader bo = new BufferedReader(fr);
        ) {
            while ( bo.ready() ){
                sb.append(bo.readLine()+"\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        String comment1RE="//[^\n]*";

        Pattern patt1=Pattern.compile(comment1RE);
        String [] parts1=patt1.split(sb);
        sb=new StringBuilder();
        for ( String part : parts1 )
            sb.append(part);

        String comment2RE="/*.*?\\*/";

        Pattern patt2=Pattern.compile(comment2RE);
        String [] parts2=patt2.split(sb);
        sb=new StringBuilder();
        for ( String part : parts2 )
            sb.append(part);

        System.out.println(sb);

    }

}
