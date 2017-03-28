package by.it.psmishenko.jd01_15;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by GN on 27.03.2017.
 */
public class TaskC {
    static String consoleReadLine() throws IOException {
        BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
        String line = buf.readLine();
        return line;
    }
    void runC(){
        boolean zxc = true;
        String root = System.getProperty("user.dir");
        String path = root + "\\src\\by\\it\\psmishenko\\jd01_14\\";
        Pattern p1 = Pattern.compile("\\s*cd\\s*");
        Pattern p2 = Pattern.compile("\\s*dir\\s*");
        Pattern p3 = Pattern.compile("\\s*exit\\s*");
        File file = new File(path);
        System.out.println("Для перехода в корень диска применяется команда cd\\ (корень - user.dir) ");
        System.out.println("Чтобы перейти из текущего подкаталога в родительский каталог применяется команда cd..");
        System.out.println("dir - вывод каталога");
        System.out.println("exit - выход из программы");
        do {
            System.out.print(path+">");
            try {
                String command = consoleReadLine();
                Matcher m1 = p1.matcher(command);
                Matcher m2 = p2.matcher(command);
                Matcher m3 = p3.matcher(command);
                if(m1.find()){
                   String t = command.substring(m1.end());
                   if(t.equals(".."))path = file.getParent()+"\\";
                   else if(t.equals("\\")) path = root+"\\";
                   else {
                       File[] list = file.listFiles();
                       boolean isHere = false;
                       String name = "" ;
                       for (File s:list) {
                           if (t.equalsIgnoreCase(s.getName()) && s.isDirectory())  {
                               isHere = true;
                               name = s.getName();}
                       }
                      if(isHere = true) path +=name+"\\";
                       else  path +=t+"\\" ;
                   }
                    file = new File(path);
                }else if(m2.find()){
                System.out.println("Содержимое папки "+path);
                dirCommand(file);
                }else if(m3.find()){
                    zxc = false;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }while (zxc);
    }
    static void dirCommand(File dir){
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        File listFile[] = dir.listFiles();
        int k = 0;
        for (File f:listFile) {
            if(f.isDirectory()) System.out.printf("%15s%12s%5s%20s\n",sdf.format(f.lastModified()),"",
                    "<DIR>",f.getName());
            else  System.out.printf("%15s%12s%-5s%20s\n",sdf.format(f.lastModified()),f.length(),
                    "",f.getName());
            k+=f.length();
        }
        System.out.printf("   %5s файлов  %15s байт\n%s байт свободно\n",listFile.length,k,dir.getFreeSpace());
    }
}
