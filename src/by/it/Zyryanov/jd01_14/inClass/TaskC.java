package by.it.Zyryanov.jd01_14.inClass;


import java.io.File;

public class TaskC {

    static void processFolder(File object){
        if (object.isFile()) {
            System.out.println("File: " + object.toString());
        }
        else {
            System.out.println("File: " + object.toString());
            File dir[] = object.listFiles();
                if (dir != null && dir.length > 0)
                    for (File f:dir)
                    processFolder(f);
        }
    }


    public static void main(String[] args) {
        String root = System.getProperty("user.dir1");
        String path = root + "/src/by/it/Zyryanov/jd01_14/";
        File file = new File(path);
        processFolder(file);
    }
}
