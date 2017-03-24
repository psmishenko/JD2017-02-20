package by.it.psmishenko.jd01_14;

import java.io.File;

/**
 * Created by user on 24.03.2017.
 */
public class TaskC {
    static void processFolder(File ob){
        if(ob.isFile()) System.out.println("File: "+ob.getName());
        else if(ob.isDirectory()) {
            System.out.println("Dir: "+ob.getName());
            File dir[] = ob.listFiles();
            if(dir.length>0&&dir!=null) for (File f:dir) processFolder(f);
        }
    }

    public static void main(String[] args) {
        String root=System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_14/";
        File file = new File(path);
        processFolder(file);
// доделать с коллекциями
    }
}
