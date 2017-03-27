package by.it.loktev.jd01_15;

import java.io.*;
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
        /*
        comment1
        */

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

        String comment2RE="/\\*[\\d\\D]*?\\*/";

        Pattern patt2=Pattern.compile(comment2RE);
        String [] parts2=patt2.split(sb);
        sb=new StringBuilder();
        for ( String part : parts2 )
            sb.append(part);

        String lineEndRE="\\n";

        String fileName2=basePath+"TaskB.txt";

        int lineNum=0;
        Pattern patt3=Pattern.compile(lineEndRE);
        String [] parts3=patt3.split(sb);
        try (
                FileWriter fw = new FileWriter(fileName2);
                BufferedWriter bw = new BufferedWriter(fw);
        )
        {
            for ( String part : parts3 ) {
                lineNum++;
                System.out.println(String.format("%2d",lineNum)+" "+part);
                bw.write(String.format("%2d",lineNum)+" "+part+"\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
