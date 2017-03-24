package by.it.smirnov.jd01_14;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Класс задачи С
 */
public class TaskC {
    private int lengthFileName;
    private String ps;
    private String psDouble;

    /**
     * Функция вывода на консоль каталогов и их содержимого (файлов), начиная с указанной папки
     * @version 1.0.0
     */
    void print(int lengthFileName, String path) {
        this.lengthFileName = lengthFileName;
        StringBuilder sb = new StringBuilder(lengthFileName);
        for (int i = 0; i < lengthFileName; i++) sb.append("─");
        this.ps = sb.toString();
        this.psDouble = ps.replaceAll("─","═");
        System.out.println("Точка входа: "+path);
        printFile("", new File(path));
    }

    /**
     * Функция печати содержимиго каталога
     * @version 1.0.0
     */
    private void printFile(String prefix, File file) {
        if (prefix == "")
            System.out.println("╔═"+psDouble+"═════════════════════════════════╗");

        Map<String, File> dirMap = new TreeMap<>();
        Map<String, File> fileMap = new TreeMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        for (File f : file.listFiles())
            if (f.isDirectory()) {
                dirMap.put(f.getName(), f);
            } else {
                fileMap.put(f.getName(), f);
            }
        Set<Map.Entry<String,File>> setm = fileMap.entrySet();
        Iterator<Map.Entry<String,File>> it = setm.iterator();
        if (prefix != "")
            System.out.println("╟─"+ps+"─┬─────────┬─────────────────────╢");

        while (it.hasNext()) {
            Map.Entry<String,File> me = it.next();
            File currFile = me.getValue();
            String fileName = currFile.getName();
            if (fileName.length() > lengthFileName) fileName = fileName.substring(0,lengthFileName);
            System.out.println(String.format("║ %-"+lengthFileName+"s │ %7d │ %s ║",fileName,currFile.length(),sdf.format(currFile.lastModified())));
            if (it.hasNext())
                System.out.println("╟─"+ps+"─┼─────────┼─────────────────────╢");
        }
        if (prefix != "")
            System.out.println("╟─"+ps+"─┴─────────┴─────────────────────╢");

        setm = dirMap.entrySet();
        it = setm.iterator();
        while (it.hasNext()) {
            Map.Entry<String,File> me = it.next();
            File currFile = me.getValue();
            System.out.println(String.format("║ %-"+(lengthFileName + 32) +"s ║",prefix+"/"+currFile.getName()));
            printFile(prefix+"/"+currFile.getName(), currFile);
        }
        if (prefix == "")
            System.out.println("╚═"+psDouble+"═════════════════════════════════╝");
    }

    public static void main(String[] args) {
        TaskC taskC = new TaskC();
        taskC.print(25,System.getProperty("user.dir")+"/src/by/it/smirnov/");
    }
}
