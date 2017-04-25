package by.it.korzun.jd02_10;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class PartA {
    private static int[] createRandomMarks(){
        int []marks = new int[5];
        for (int i = 0; i < marks.length; i++) {
            marks[i] = (int)(Math.abs(Math.random()*10-4));
        }
        return marks;
    }

    static void run() {
        System.out.println("Part A:");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        List<Student> list = new ArrayList<>();
        list.add(new Student("Alex", 3, createRandomMarks()));
        list.add(new Student("Pasha", 2, createRandomMarks()));

        String json = gson.toJson(list);
        System.out.println(json);

        List<Student> demarshList = gson.fromJson(json, List.class);
        System.out.println("Demarshed List:\n" + demarshList);

    }
}
