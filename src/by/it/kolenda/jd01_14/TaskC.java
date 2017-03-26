package by.it.kolenda.jd01_14;

import java.io.File;

public class TaskC {

    static void processFolder(String prefix, File object) {
        if (object.isFile())
            System.out.println("File:" + object.toString());
        else {
            System.out.println("File:" + object.toString());
            File dir[] = object.listFiles();
            if (dir != null && dir.length > 0)
                for (File f : dir)
                    processFolder(prefix + "", f);
        }
    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/kolenda/jd01_14/";
        File file = new File(path);
        processFolder("", file);

    }
}
