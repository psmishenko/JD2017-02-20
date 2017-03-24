package by.it.kolenda.jd01_14;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TaskA {
    public static void main(String[] args) {

    String root = System.getProperty("user.dir");
    String path = root + "/src/by/it/kolenda/jd01_14/";
    String fileName = path + "TaskA.data";

   try {
       FileOutputStream fs = new FileOutputStream(fileName);
       BufferedOutputStream bo = new BufferedOutputStream(fs);
       DataOutputStream dout = new DataOutputStream(bo);

       for (int i = 0; i < 20; i++) {

           int value = (int) (Math.random() * 100.0);
           dout.writeInt(value);
       }

   } catch (IOException e){
       e.printStackTrace();
   }
// data restoring

        try ( FileInputStream fi = new FileInputStream(fileName);
            BufferedInputStream bi = new BufferedInputStream(fi);
                DataInputStream dinput = new DataInputStream(bi)) {
                    List<Integer> values = new ArrayList<>();
//              for (int i = 0; i < 20; i++) {

                    int sum = 0;

            while(dinput.available()>0);

                    {
                        int value = dinput.readInt();
                        sum += value;
                        values.add(value);
                    }

        System.out.println(values);
        System.out.printf("Average = \n",(double)sum/values.size());
                }

        catch (IOException e) {
       e.printStackTrace();
        }
    }
}

