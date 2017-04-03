package by.it.akhmelev.jd01_15;


import java.nio.file.Path;
import java.nio.file.Paths;

public class ExamplePath {
    public static void main(String[] args) {
        String src=System.getProperty("user.dir")+"/src/by/it/akhmelev/";
        String fileInTxt = src+"jd01_15/in.txt";

        // Cоздание объекта Path через вызов статического метода get() класса Paths
        Path testFilePath = Paths.get(fileInTxt);

        //Вывод информации о файле
        System.out.println("Printing file information: ");
        System.out.println("\t file name: " + testFilePath.getFileName());
        System.out.println("\t root of the path: " + testFilePath.getRoot());
        System.out.println("\t parent of the target: "
                + testFilePath.getParent());

        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }
    } }
