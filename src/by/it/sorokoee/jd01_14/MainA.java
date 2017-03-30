package by.it.sorokoee.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainA {
    public static void main(String[] args) {
        String root=System.getProperty("user.dir");
        String path =root+ "/src/by/it/sorokoee/jd01_14/";
        String fileName = path + "main.data";
        try (FileOutputStream ts = new FileOutputStream(fileName);
             BufferedOutputStream bf = new BufferedOutputStream(ts);
             DataOutputStream dt = new DataOutputStream(bf);) {
            for (int i = 0; i < 2; i++) {
                int value = (int) (Math.random() * 100.0);
                dt.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileInputStream fi = new FileInputStream(fileName);
             BufferedInputStream bf = new BufferedInputStream(fi);
             DataInputStream dt = new DataInputStream(bf);) {
            List<Integer> values = new ArrayList<>();
            int summa = 0;
            while (dt.available() > 0) {
                int val = dt.readInt();
                summa += val;
                values.add(val);
            }
            System.out.println(values);
            if (values.size() > 0) {
                System.out.println((double) summa / values.size());
            } else {
                System.out.println("No data");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
