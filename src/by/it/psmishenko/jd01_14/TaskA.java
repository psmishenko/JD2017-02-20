package by.it.psmishenko.jd01_14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 24.03.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        String root=System.getProperty("user.dir");
        String path = root + "/src/by/it/psmishenko/jd01_14/";
        String filename = path+"taskA.data";
        try  (FileOutputStream fs = new FileOutputStream(filename); // FileOutputStream(filename) - повт. запуск перезапишет файл
              BufferedOutputStream bo = new BufferedOutputStream(fs);
              DataOutputStream dos = new DataOutputStream(bo)){
            for (int i = 0; i <20 ; i++) {
                int value = (int) (Math.random()*100.0);
                dos.writeInt(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        //
        try (FileInputStream fi = new FileInputStream(filename);
        BufferedInputStream bi = new BufferedInputStream(fi);
        DataInputStream dis = new DataInputStream(bi)) {
            List<Integer> val = new ArrayList<>();
            int sum = 0;
           while (dis.available()>0){
                int value = dis.readInt();
                val.add(value);
                 sum+=value;
            }
            if (val.size()==0){
                System.out.println("No data");
            }else System.out.println(val+"  Среднее арифметическое - "+(double) sum/val.size());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
