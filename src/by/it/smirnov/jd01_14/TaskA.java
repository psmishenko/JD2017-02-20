package by.it.smirnov.jd01_14;

import java.io.*;

/**
 * Класс задачи A
 */
public class TaskA {
    /**
     * Функция записывает в двоичный файл 20 случайных чисел от 0 до 999.
     * Читает записанный файл, распечатывает числа и их среднее арифметическое.
     * @version 1.0.0
     */
    public static void main(String[] args) {
        String path = System.getProperty("user.dir")+"/src/by/it/smirnov/jd01_14/";
        String fileName = path + "taskA.data";
        try (DataOutputStream dout = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(fileName)))){
            for (int i = 0; i < 20; i++) {
                int value = (int)(Math.random()*1000);
                System.out.println(value);
                dout.writeInt(value);
            }

        } catch (IOException e) {

        }
        System.out.println("Вывод из файла:");
        try (DataInputStream dint = new DataInputStream(new BufferedInputStream(new FileInputStream(fileName)));){
            int b;
            int count = 0;
            int sum = 0;
            while (dint.available() > 0) {
                b=dint.readInt();
                System.out.println(b);
                sum +=b;
                count++;
            }
            if (count>0) {
                System.out.println("Среднее арифметическое: "+(double)sum/count);
            } else {
                System.out.println("Кол-во элементов 0");
            }

        } catch (IOException e) {

        }
    }
}
