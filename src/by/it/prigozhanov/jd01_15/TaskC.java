package by.it.prigozhanov.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by v-omf on 3/28/2017.
 *
 * @author v-omf
 */
public class TaskC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String root = System.getProperty("user.dir");
        System.out.print(root);
        while (true) {
            String consolePath = reader.readLine();
            String path = root + consolePath;
            File f = new File(path);
            String[] list = f.list();
            System.out.println(path);
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}
