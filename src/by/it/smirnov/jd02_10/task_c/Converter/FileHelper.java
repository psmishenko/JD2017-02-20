package by.it.smirnov.jd02_10.task_c.Converter;

import java.io.*;

/**
 * Класс вспомогательных функций чтения и записи в файл
 */
public class FileHelper {
    public static String readFromFile(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла: " + e);
        }
        return sb.toString();
    }

    public static void writeToFile(File file, String txtData) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
            bw.write(txtData);
        } catch (IOException e) {
            System.err.println("Файл не может быть создан: " + e);
        }
    }

    public static String readFromFile(String fileName) {
        return readFromFile(new File(fileName));
    }

    public static void writeToFile(String fileName, String txtData) {
        writeToFile(new File(fileName), txtData);
    }
}
