package by.it.radivonik.jd01_14;

import java.io.File;
import java.util.*;

/**
 * Created by Radivonik on 24.03.2017.
 * Класс, реализующий задания Варианта С
 */
public class TaskC {
    public static void run () {
        String path = System.getProperty("user.dir") + "/src/by/it/radivonik";
        File dir = new File(path);
        List<String> listTree = new ArrayList<>(); // дерево кпапок и файлов
        List<String> listDir = new ArrayList<>();  // отдельно папки
        List<String> listFile = new ArrayList<>(); // отдельно файлы

        procFolder(dir,"",listTree,listDir,listFile);

        // Печать
        listPrint(listTree,"Дерево папок и файлов");
        listPrint(listDir,"Список папок");
        listPrint(listFile,"Список файлов");
    }

    /**
     * Метод, реализующий обход по всем вложенным папкам и файлам, содержит рекурсию
     * @param obj объект класса File - папка верхнего уровня или файл
     * @param prefix строка для печати отступа
     * @param listTree список для дерева папок и файлов
     * @param listDir список для папок
     * @param listFile список для файлов
     */
    public static void procFolder(File obj, String prefix, List<String> listTree, List<String> listDir, List<String> listFile) {
        if (obj.isFile()) {
            listTree.add(prefix + obj.getName().toString());
            listFile.add(obj.getName().toString());
        }
        else {
            listTree.add(prefix + "[" + obj.toString() + "]");
            listDir.add(obj.toString());
            List<File> filelist = new ArrayList<>(Arrays.asList(obj.listFiles()));
            for (int i = 0; i < filelist.size(); i++) {
                procFolder(filelist.get(i),prefix+"  ",listTree,listDir,listFile);
            }
        }
    }

    /**
     * Метод, реализующий печать списка строк
     * @param list список строк
     * @param caption заголовок перед списком
     */
    public static void listPrint(List<String> list, String caption) {
        System.out.println(caption);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}
