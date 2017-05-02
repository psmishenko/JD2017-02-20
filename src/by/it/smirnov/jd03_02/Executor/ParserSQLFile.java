package by.it.smirnov.jd03_02.Executor;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ParserSQLFile {
    private static String readFromFile(File file) {
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
    public static String[] getArrSQL(String fileName){
        return readFromFile(new File(fileName)).split(";");
    }
}
