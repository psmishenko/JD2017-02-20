package by.it.psmishenko.jd01_15;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by user on 27.03.2017.
 */
public class TaskB {
    void runB() {
        StringBuilder sb = new StringBuilder(); //111hophaylalalay
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_15/";
        String filename1 = path + "TaskB.java"; //gkdlgkdlfld
        try (BufferedReader br = new BufferedReader(new FileReader(new File(filename1)))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*

        1234567890
         */
        /* 123 */
        String regex = "(/{2}.+)|(\\/\\*\\s+.+\\s+\\*\\/)|(\\/\\*\\*\\s+.+\\s+\\*\\/)";
        Pattern p1 = Pattern.compile(regex);
        Matcher m1 = p1.matcher(sb);
        int k = 0;
        while (m1.find(k)){
            int m = sb.substring(m1.start(),m1.end()).length();
           sb.delete(m1.start(),m1.end());
            k = m1.end()-m;
        }
        System.out.println(sb);
        String filename2 = path+"TaskB.txt";
        try( PrintWriter pr = new PrintWriter(new FileWriter(filename2))) {
            Pattern pattern = Pattern.compile("[\n]+");
            Matcher matcher = pattern.matcher(sb);
            int b = 0;
            int c = 0;
            while (matcher.find()){
                c++;
                pr.printf("%s (%2d)",sb.substring(b,matcher.start()),c);
                System.out.printf("%s (%2d)",sb.substring(b,matcher.start()),c);
                b = matcher.start();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}