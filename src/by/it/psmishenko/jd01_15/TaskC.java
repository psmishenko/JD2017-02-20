package by.it.psmishenko.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by GN on 27.03.2017.
 */
public class TaskC {
    static String consoleReadLine() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        //buf.close();
        return line;
    }
    void runC(){
        boolean zxc = true;
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_15/";
        File file = new File(path);
        do {
            System.out.print(path+">");
            try {
                String command = consoleReadLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (zxc);
    }
}
