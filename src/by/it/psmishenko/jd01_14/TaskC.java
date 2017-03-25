package by.it.psmishenko.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24.03.2017.
 */
public class TaskC {
    static void processFolder(File ob,List<String> files,List<String> directory){
        String delimiter = "      ";
        if(ob.isFile()) {System.out.println("File:"+delimiter+ob.getName()); files.add(ob.getName());}
        else if(ob.isDirectory()) {
          System.out.println("Dir: "+ob.getName()); directory.add(ob.getName());
            File dir[] = ob.listFiles();
            if(dir.length>0&&dir!=null) for (File f:dir) processFolder(f,files,directory);
            System.out.println("---------END OF DIRECTORY----------------------------");
        }
    }

    public static void main(String[] args) {
        String root=System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_14/";
        File file = new File(path);
        List<String> fileList = new ArrayList<>();
        List<String > dirList = new ArrayList<>();
        processFolder(file, fileList,dirList);
        System.out.println("Печать только файлов:");
        for (String i:fileList) System.out.println("File name:   "+i);
        System.out.println("Печать только каталогов:");
        for (String j:dirList) System.out.println("Dir name:   "+j);
    }
}
