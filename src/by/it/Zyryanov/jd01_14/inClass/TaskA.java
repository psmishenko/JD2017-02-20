package by.it.Zyryanov.jd01_14.inClass;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir1");
        String path = root + "/src/by/it/Zyryanov/jd01_14";
        String filename = path + "taskA.data";
        try (FileOutputStream fs = new FileOutputStream(filename);
             BufferedOutputStream bo = new BufferedOutputStream(fs);
             DataOutputStream dout = new DataOutputStream(bo)) {

            for (int i = 0; i < 20; i++) {
                int value = (int) (Math.random() * 100.0);
                dout.writeInt(value);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        //восстановление данных

        try (FileInputStream fi = new FileInputStream(filename);
             BufferedInputStream bi = new BufferedInputStream(fi);
             DataInputStream dinput = new DataInputStream(bi)){
                List<Integer> values = new ArrayList<>();

            double sum = 0;
            while (dinput.available()>0){
                int value = dinput.readInt();
                values.add(value);
                sum+=value;
            }
            System.out.println(values);
            if (values.size() > 0){
                System.out.printf("Average =% f", (double)sum/values.size());
            } else {
                System.out.println("No data");
            }
        }

        catch(IOException e){
            e.printStackTrace();
        }

    }
}
