package by.it.smirnov.jd01_15;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Аналог командной строки Windows. Реализует dir и cd
 */
public class TaskC {
    private File currPath;

    public TaskC(File currPath) {
        this.currPath = currPath;
    }

    public File getCurrPath() {
        return currPath;
    }

    /**
     * Функция печати содержимиго каталога
     * @version 1.0.0
     */
    private void printDir() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy  HH:mm");
        int countFile = 0;
        int countDir = 0;
        int sizeFiles = 0;
        System.out.println(" Содержимое папки "+currPath.toString());
        for (File f : currPath.listFiles())
            if (f.isDirectory()) {
                System.out.println(String.format("%s     %5s          %s",sdf.format(f.lastModified()), "<DIR>", f.getName()));
                countDir++;
            } else {
                System.out.println(String.format("%s     %5s%,9d %s",sdf.format(f.lastModified()), "",f.length(), f.getName()));
                countFile++;
                sizeFiles += f.length();
            }
        System.out.println(String.format("%16d файлов %,d байт",countFile, sizeFiles));
        System.out.println(String.format("%16d папок %,d байт свободно",countDir, currPath.getFreeSpace()));
    }

    /**
     * Функция смены текущего директория
     * @param newDirectory новый директорий
     * @version 1.0.0
     */
    private void changeDir(String newDirectory) {
        try {
            String newPath = (newDirectory.equals("\\")) ?
                    currPath.toPath().getRoot().toString() : currPath.getCanonicalPath() + "/" + newDirectory;

            File f = new File(newPath);
            if (!f.isDirectory()) throw new IOException("");
            currPath = f;
        } catch (IOException e) {
            System.out.println("Системе не удается найти указанный путь.");
        }
    }

    public static void main(String[] args) throws IOException {
        TaskC taskC = new TaskC(new File(System.getProperty("user.dir")+"/src/by/it/smirnov/"));
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print(taskC.getCurrPath().getCanonicalPath()+">");
            String str = sc.nextLine();
            if (str.equals("exit")) break;
                else {
                if (str.equals("dir")) taskC.printDir();
                else {
                    if (str.startsWith("cd ")) taskC.changeDir(str.substring(3));
                    else System.out.println("Неизвестная команда");
                }
            }
        }
    }
}
