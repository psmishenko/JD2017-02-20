package by.it.korzun.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {
        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/korzun/jd01_14/";
        String fileName = path + "TaskA.data";
        try (FileOutputStream fs = new FileOutputStream(fileName);
             BufferedOutputStream bo = new BufferedOutputStream(fs);
             DataOutputStream dout = new DataOutputStream(bo)){

            for (int i = 0; i < 20; i++) {
                int value = (int)(Math.random()*100.0);
                dout.writeInt(value);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        try(FileInputStream fi = new FileInputStream(fileName);
            BufferedInputStream bi = new BufferedInputStream(fi);
            DataInputStream din = new DataInputStream(bi)){

            Double sum = 0.0;
            List<Integer> values = new ArrayList<>();

            while(din.available() > 0) {
                int value = din.readInt();
                values.add(value);
                sum += value;
            }

            if(values.size() == 0){
                System.out.println("Нет данных");
            }else {
                System.out.println(values + "\nСреднее арифмитическое: " + sum / values.size());
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
