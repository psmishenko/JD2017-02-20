package by.it.sorokoee.jd01_15;

import java.io.*;

/*
jhjgyg
khbjhbkj
 */
public class MainB {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/sorokoee/jd01_15/";
        String fileName = path + "MainB.java";
        FileReader fr;
        BufferedReader br = null;
        StringBuilder text = new StringBuilder();

        // mhbhcgc
        //khbgjhj

        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (br.ready()) {
                text.append(br.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        System.out.println(text);


        String fileNameTxt = path + "MainB.txt";

        try (FileWriter f = new FileWriter(fileNameTxt);
             PrintWriter printWriter = new PrintWriter(f)) {
            printWriter.print(text.toString());
            printWriter.flush();

        } catch (IOException e) {

        }

    }

}
