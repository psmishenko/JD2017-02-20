package by.it.vedom.jd01_15;

import java.io.*;

public class TaskA {

    public void runTaskA(String name) throws IOException {

        try {

            String root = System.getProperty("user.dir");
            String path = root + "/src/by/it/vedom/jd01_15/";
            String fileName = path + "matrix.txt";

            FileWriter fileWriter = new FileWriter(fileName);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int matrix[][] = new int[4][4];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = ((int) (Math.random()*30) - 15);
                }
            }
            int temp =0;
            System.out.println("Ваша матрица: ");
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    temp++;
                    System.out.printf("%s[%d][%d]= %-3d ", name, i, j, matrix[i][j]);
                    printWriter.printf("%s[%d][%d]= %-3d ", name, i, j, matrix[i][j]);

                    if(temp % 4 == 0) {
                        System.out.println();
                        printWriter.println();
                    }
                }
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e) {
            System.out.println("Ошибка создания файла");
            e.getMessage();
        }
        catch (IOException e) {
            System.out.println("Ошибка записи в файл");
            e.getMessage();
        }

    }
}
