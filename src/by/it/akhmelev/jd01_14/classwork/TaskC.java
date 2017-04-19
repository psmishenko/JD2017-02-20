package by.it.akhmelev.jd01_14.classwork;

import java.io.File;

public class TaskC {

    static void processFolder(String prefix,File object) {
        if (object.isFile()) {
            System.out.println("File:" +prefix+ object.getName());
        } else {
            System.out.println("Dir: " +prefix+ object.getName());
            File dir[]=object.listFiles();
            if (dir!=null && dir.length>0)
            for (File f:dir)
                processFolder(prefix+"   ",f);
        }

    }

    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/akhmelev/jd01_14/classwork/";
        File file = new File(root);
        processFolder("",file);
    }
}
