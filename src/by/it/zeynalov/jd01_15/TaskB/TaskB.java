package by.it.zeynalov.jd01_15.TaskB;

import java.io.*;


public class TaskB {
    public static void main(String[] args) {
        String path = System.getProperty("user.dir") + "/src/by/it/zeynalov/jd01_15/TaskB/";
        StringBuilder sb = new StringBuilder(); //объявили StringBuilder
        int n = 1;

        try (BufferedReader br = new BufferedReader(new FileReader(path + "TaskB.java"))) {
            String sg;
            while ((sg = br.readLine()) != null) {
                if (sg.contains("//") && sg.charAt(sg.indexOf("//") - 1) != '\"') {
                    sg = sg.substring(0, sg.indexOf("//"));
                }
                sg = String.format("%2d %s", n, sg);
                n++;
                sb.append(sg + "\n");
            }
        } catch (IOException e) { //ловим ошибки
            e.printStackTrace();
        }
        try (PrintWriter out = new PrintWriter(path + "TaskB.txt")) {
            out.print(sb.toString());
        }catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(sb.toString());
    }
}
