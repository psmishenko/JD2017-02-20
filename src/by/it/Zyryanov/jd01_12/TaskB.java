package by.it.Zyryanov.jd01_12;


import by.it.Zyryanov.jd01_06.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class TaskB {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        int counter = 0;

        String[] words = TaskB_Data.text.split("[^A-Za-z]+");
        for (int i = 0; i < words.length; i++) {
            list.add(words[i]);
            counter++;
            for (int j = 0; j < words.length; j++) {

            }
        }
        for (int i = 0; i < list.size(); i++) {
            int sum = 0;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(i).contains(list.get(j))){
                    sum++;
                }
            }
            System.out.println("Word :" + list.get(i) + " = " + sum + " times.");
        }
    }
}