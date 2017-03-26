package by.it.loktev.jd01_14;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TaskC {

    static List<String> foldersList=new ArrayList<String>();
    static List<String> filesList=new ArrayList<String>();

    static void processFolder(File folder){

        File [] files=folder.listFiles();
        //System.out.println(Arrays.toString(files));
        for ( File f : files ){
            //System.out.println(f);

            if ( f.isDirectory() ){
                foldersList.add(f.getPath());
                processFolder(f);
            }
            if ( f.isFile() ){
                filesList.add(f.getPath());
            }

        }

    }

    public static void taskC() {

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_14/";
        File folder=new File(basePath);
        processFolder(folder);

        System.out.println("Все папки:");
        for ( String f : foldersList )
            System.out.println(f);
        System.out.println("Все файлы:");
        for ( String f : filesList )
            System.out.println(f);

    }

}
