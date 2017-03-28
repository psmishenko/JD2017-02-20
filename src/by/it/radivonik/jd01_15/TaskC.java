package by.it.radivonik.jd01_15;

import java.io.*;
import java.nio.file.*;
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
                        Path pfile = Paths.get(file.getAbsolutePath());
                        System.out.printf(
                            "%-28s %-5s %8s %s\n",
                            Files.getAttribute(pfile,"lastModifiedTime",LinkOption.NOFOLLOW_LINKS),
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
        catch (IOException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
