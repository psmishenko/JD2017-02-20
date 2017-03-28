package by.it.sorokoee.calculator;

import java.io.*;
import java.util.Map;

import static by.it.sorokoee.calculator.Var.vars;

public class ConsolRunner {
    static String root = System.getProperty("user.dir");
    static String path = root + "/src/by/it/sorokoee/calculator/";
    static String fileName = path + "vars.txt";


    private static void writeMap() {
        try (PrintWriter printer =
                     new PrintWriter(
                             new FileWriter(fileName), true)) {
            for (Object o : vars.entrySet()) {
                Map.Entry pair = (Map.Entry) o;
                printer.println(pair.getKey() + ":" + pair.getValue());
            }


        } catch (IOException e) {
            try {
                throw new IOException("Not write " + fileName, e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
    private static void loadMap() {
        FileReader fr;
        BufferedReader br = null;
        StringBuilder text = new StringBuilder();


        try {
            fr = new FileReader(fileName);
            br = new BufferedReader(fr);
            while (br.ready()) {
                text.append(br.readLine()).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(text);
        }
    }
    private static void oneRes(Var var) {
        if (var != null) {
            System.out.println(var);

        }
    }




    public static void main(String[] args) {
//        oneRes(new VarF("3.8").add(new VarF("26.2")));
//        oneRes(new VarF("87.4").sub(new VarF("23.1")));
//        oneRes(new VarF("1.04").mul(new VarF("5.9")));
//        oneRes(new VarF("12.7").div(new VarF("5")));
//        Var vec1=new VarV("{1.2,2.2,3.2,4.2,5.4}");
//        Var vec2=new VarV("{1,2,3,4}");
//
//        oneRes(Parser.calc("5/0"));
//        oneRes(Parser.calc(vec1+"+"+vec2));

        Parser.calc("A=3");
        Parser.calc("B={1,2,3,4}");
        Parser.calc("C=9");
        Parser.calc("A=7");
        writeMap();
        Parser.calc("A=4");
        Parser.calc("Y={1,2,3,4}");
        Parser.calc("Z=9");
        Parser.calc("D=7");
        writeMap();
        loadMap();
        Parser.calc("q=23");
        Parser.calc("f={1,2,3,4,5}");
        Parser.calc("k=94");
        Parser.calc("h=75");
        writeMap();
        loadMap();


//        System.out.println(vars);
//        oneRes(vec2.mul(new VarF(2)));
//        oneRes(vec2.div(new VarF(3)));
//        oneRes(vec2.sub(new VarF(5)));
//        oneRes(new VarF(-4).add(vec1));
//
//
//        oneRes(Parser.calc("1+1"));
//
//
//        System.out.println(Var.vars);
//
//        oneRes(vec1.add(vec2));
//        oneRes(vec1.sub(vec2));
//        oneRes(vec1.mul(vec2));
//        oneRes(vec1.div(vec2));


    }
}
