package by.it.loktev.jd01_14;

import java.io.*;

public class TaskA {

    public static void main(String[] args) {
        taskA();
    }

    public static void taskA()  {

        String basePath=System.getProperty("user.dir")+"/src/by/it/loktev/jd01_14/";
        String fileName=basePath+"taskA.data";

        try (
                FileOutputStream fs=new FileOutputStream(fileName);
                BufferedOutputStream bo=new BufferedOutputStream(fs);
                DataOutputStream dos=new DataOutputStream(bo);
        )
        {
            for (int i = 0; i < 30; i++) {
                int value=(int)(Math.random()*100);
                dos.writeInt(value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileInputStream fs=new FileInputStream(fileName);
                BufferedInputStream bo=new BufferedInputStream(fs);
                DataInputStream dos=new DataInputStream(bo);
        )
        {
            int sum=0;
            int count=0;
            while (dos.available()>0) {
                int value=dos.readInt();
                System.out.print(value+" ");
                sum+=value;
                count++;
            }
            if (count>0)
              System.out.println("\nСреднее арифметическое: "+(double)sum/count);
            else
                System.out.println("Нет данных");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
