package by.it.ikavalenka.jd_14;

import java.io.File;

/**
 * Created by USER on 24.03.2017.
 */
public class TaskC {

    static void  processFolder(String prefix,File object){
        if (object.isFile()) {
//            System.out.println("File:" + prefix + object.toString());
            System.out.println("File:" + prefix + object.getName());
        }
            else {
//            System.out.println("File:" + prefix + object.toString());
            System.out.println("File:" + prefix + object.getName());

            File dir[] =  object.listFiles();
            if (dir !=null && dir.length>0)
            for (File f : dir)
                processFolder(prefix+ "   ",f);
            }
    }
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/ikavalenka/jd_14/";
File file = new File(path);
//        File file = new File(root);
        processFolder("  ",file);

    }
}
