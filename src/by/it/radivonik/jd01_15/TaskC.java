package by.it.radivonik.jd01_15;

import java.io.*;
import java.nio.file.*;
import java.text.DateFormat;
import java.util.*;

/**
 * Created by Radivonik on 27.03.2017.
 * Класс, реализующий задания Варианта C
 */
public class TaskC {
    public void run() {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik";
        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        try {
            System.out.println("Эмуляция командной строки (exit - выход)");
            while (!(cmd.toLowerCase().equals("exit"))) {
                File dir = new File(path);
                System.out.print(dir.getPath() + ">");
                cmd = scanner.nextLine();

                // Обработка команды dir
                if (cmd.toLowerCase().equals("dir")) {
                    for (File file: dir.listFiles()) {
                        Date d = new Date(file.lastModified());
                        DateFormat df = DateFormat.getDateInstance(DateFormat.DEFAULT,new Locale("ru","RU"));
                        DateFormat tf = DateFormat.getTimeInstance(DateFormat.DEFAULT,new Locale("ru","RU"));
                        System.out.printf(
                            "%10s %8s %5s %8s %s\n",
                            df.format(d),
                            tf.format(d),
                            file.isDirectory()?"<DIR>":"",
                            file.isDirectory()?"":file.length(),
                            file.getName());
                    } ;
                }
                // Обработка команды cd
                else if (cmd.substring(0,2).toLowerCase().equals("cd")) {
                    String cmdArg = cmd.substring(3);
                    String pathChk = "";
                    if (cmdArg.equals(".."))
                        pathChk = dir.getParent();
                    else if (cmdArg.contains(":")) {
                        pathChk = cmdArg;
                        if (pathChk.lastIndexOf(":") == pathChk.length() - 1)
                            pathChk = pathChk + "/";
                    }
                    else
                        pathChk = path + "/" + cmdArg;
                    if (!Files.exists(Paths.get(pathChk)) || !Files.isDirectory(Paths.get(pathChk)))
                        System.out.printf("  Папка %s не найдена\n",pathChk);
                    else
                        path = pathChk;
                }
            }
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
