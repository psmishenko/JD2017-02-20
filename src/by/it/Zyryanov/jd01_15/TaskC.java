package by.it.Zyryanov.jd01_15;


import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class TaskC {
    public static void main(String[] args) throws IOException{


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file = new File("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by");
        File file1 = new File("/Users/georgijzyranov/");
        File file2 = new File("/Users/georgijzyranov/Documents/Git Hub Homework /JD2017-02-20/src/by/it/Zyryanov");
        File[] listOfFiles = file.listFiles();
        File[] listOfFiles1= file1.listFiles();
        String[] listOfFiles2 = file2.list();


        while (true) {
            System.out.println("--------------------------------------------------");

            for (File s:listOfFiles) {
                System.out.println(s.toString());
            }
            System.out.println("--------------------------------------------------");
            System.out.println("\n" + "enter cd to change directory\ndir to see all folders in this directory");

            String st = reader.readLine();

            if (st.equals("dir")){
                for (File s:listOfFiles1){
                    System.out.println(s.toString());
                }
            } else if (st.equals("dir/Zyryanov")){
                for (String f: listOfFiles2) {
                    System.out.println(f);
                }
            } else if (st.equals("exit")) {
                System.out.println("Goodbuy!");
                break;
            } else {
                System.out.println("no such command!");
            }
        }
    }
}
