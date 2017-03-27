package by.it.psmishenko.jd01_15;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.03.2017.
 */
public class TaskB {
    void runB() {
        StringBuilder sb = new StringBuilder(); // hophaylalalay
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_15/";
        String filename1 = path + "TaskB.java"; // gkdlgkdlfld
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename1)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb);
     /*   Pattern p1 = Pattern.compile("[]");
        Matcher m1 = p1.matcher(sb);
        while (m1.find()){

        }*/
    }
}