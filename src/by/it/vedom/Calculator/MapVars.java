package by.it.vedom.Calculator;


import java.io.*;

class MapVars {
    private static String getFilename() {
        String src = System.getProperty("user.dir") + "/src/by/it/vedom/";
        return src + "Calculator/vars.txt";
    }

    private MapVars() {} //запрет на создание экземпляра класса MapVars

    /** запись в текстовый файл */
    static void saveMapToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(getFilename()))) {
            //Var.vars уже имеет анонимный класс с toString нужного формата (A=9 и т.д.)
            out.print(by.it.akhmelev.jd01_15_matlab_demo.Var.vars);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** чтение из текстового файла */
    static void loadMapFromFile() throws MathExeption {
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
