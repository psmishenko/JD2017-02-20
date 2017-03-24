package by.it.radivonik.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Radivonik on 24.03.2017.
 */
public class TaskC {
    public static void run () {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik";
        File dir = new File(path);
        procFolder(dir,"");
    }

    public static void procFolder(File obj, String prefix) {
        if (obj.isFile())
            System.out.println(prefix + "Файл: " + obj.toString());
        else {
            System.out.println(prefix + "Папка: " + obj.toString());
            List<File> filelist = new ArrayList<File>(Arrays.asList(obj.listFiles()));
            for (int i = 0; i < filelist.size(); i++) {
                procFolder(filelist.get(i),prefix+"  ");
            }
        }
    }
}
