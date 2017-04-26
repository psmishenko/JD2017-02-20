package by.it.Zyryanov.jd01_12;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;


public class TaskB2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите количество элементов: ");
        int number = Integer.parseInt(reader.readLine());
        //Старт ArrayList
        long startTime = System.currentTimeMillis();
        processArray(createList(number));
        System.out.println("ArrayList закончил за : " + (System.currentTimeMillis() - startTime));
        //Конец АrrayList
        //Старт LinkedList
        long startTime2 = System.currentTimeMillis();
        procesLinked(createLinkedList(number));
        System.out.println("LinkedList закончил за : " + (System.currentTimeMillis() - startTime2));
        //Конец LinkedList
    }



    public static ArrayList createList(int number) {
        ArrayList <Integer> list = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            list.add(i);
        }
        return list;
    }

    public static LinkedList createLinkedList(int number) {
        LinkedList <Integer> list = new LinkedList<>();
        for (int i = 0; i < number; i++) {
            list.add(i);
        }
        return list;
    }


    public static void processArray (ArrayList<Integer> list){
        while(list.size() > 1){
            list.remove(1);
        }
    }

    public static void procesLinked (LinkedList<Integer> list){
        while(list.size() > 1){
            list.remove(1);
        }
    }




}
