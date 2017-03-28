package by.it.Zyryanov.jd01_15;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        String path = "/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov/jd01_15/";
        String filename = path + "TaskB.java";


        //comment
        StringBuilder sb = new StringBuilder();

        try (FileReader reader = new FileReader(filename)) {
            while (reader.ready()) {
                sb.append((char) reader.read());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //gkgsklfngjnsjklrb
        //коммент
        /*тпловиыпдл
          выжпрлдыв
          пыждвпт*/


        //Pattern pattern1 = Pattern.compile("([/]){2}([А-Яа-яёЁA-Za-z0-9]*)*([\\n])");

        Pattern pattern2 = Pattern.compile("(?:/\\*(?:[^*]|(?:\\*+[^*/]))*\\*+/)|(?://.*)");
        //  Matcher matcher = pattern1.matcher(sb);
        Matcher matcher2 = pattern2.matcher(sb);


        while (matcher2.find()) {
            int start = 0;
           start =  matcher2.start();
            int end = 0;
            end = matcher2.end();
            sb.delete(start, end);
            matcher2.reset();
        }

        String sb2 = sb.toString();

        String lineEndRE="\\n";

        String fileName2=path+"TaskB.txt";

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


