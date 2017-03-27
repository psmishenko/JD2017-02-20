package by.it.loktev.jd01_15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private File currFolder;

    public TaskC(){
        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_15/";
        currFolder=new File(basePath);
    }

    private void showDir(){


                /*
 Содержимое папки D:\WORK\Курсы\Java\JD2017-02-20\src\by\it\loktev\jd01_15

27.03.2017  11:30    <DIR>          .
27.03.2017  11:30    <DIR>          ..
27.03.2017  11:04                68 matrix.txt
27.03.2017  11:30               402 Runner.java
27.03.2017  10:27             1 203 TaskA.java
27.03.2017  11:04             2 002 TaskB.java
27.03.2017  11:04             2 034 TaskB.txt
27.03.2017  11:30             1 398 TaskC.java
               6 файлов          7 107 байт
               2 папок  267 986 931 712 байт свободно
                 */
        try {
            System.out.println("Содержимое папки "+currFolder.getCanonicalPath());

            int filesCount=0;
            int foldersCount=0;

            SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
            File [] files=currFolder.listFiles();
            //System.out.println(Arrays.toString(files));
            for ( File f : files ){
                String fileStr="";
                fileStr+=sdf.format(f.lastModified());
                if ( f.isDirectory() ){
                    fileStr+=" <DIR> ";
                    fileStr+="         ";
                    foldersCount++;
                }
                else {
                    fileStr+="       ";
                    fileStr+=String.format("%9d",f.length());
                    filesCount++;
                }
                fileStr+=" "+f.getName();

                System.out.println(fileStr);
            }
            System.out.println(filesCount+" файлов");
            System.out.println(foldersCount+" папок");

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void listenCommands(){

        Scanner scanner=new Scanner(System.in);

        while ( true ){
            String command = scanner.nextLine();

            if ( command.equals("quit") )
                break;
            else if ( command.equals("dir") )
                showDir();
            else
              System.out.println("Unknown command");
        }

        System.out.println("Bye-bye!");
    }

    public void taskC(){


        /*
*/



    }

}
