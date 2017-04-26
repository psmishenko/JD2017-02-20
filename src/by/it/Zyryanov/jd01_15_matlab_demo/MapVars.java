package by.it.Zyryanov.jd01_15_matlab_demo;

import java.io.*;

/**
 * Класс содержит ститические методы записи и чтения карты переменных
 */
class MapVars {
    private static String getFilename() {
        String src = System.getProperty("user.dir") + "/src/by/it/akhmelev/";
        return src + "jd01_15_matlab_demo/vars.txt";
    }

    private MapVars() {} //запрет на создание экземпляра класса MapVars

    /** запись в текстовый файл */
    static void saveMapToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(getFilename()))) {
            //Var.vars уже имеет анонимный класс с toString нужного формата (A=9 и т.д.)
            out.print(Var.vars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** чтение из текстового файла */
    static void loadMapFromFile() {
        File file = new File(getFilename());
        if (file.exists())
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = in.readLine()) != null) {
                    Parser.calc(line);
                }
                in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
    }


}
