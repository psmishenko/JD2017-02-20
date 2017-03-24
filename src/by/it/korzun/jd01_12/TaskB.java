package by.it.korzun.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB {
    void runB1(){
        String text;
        Map<String, Integer> map;
        Pattern pattern = Pattern.compile("[.,;:?()]");
        Matcher matcher = pattern.matcher(EnglishText.text);
        text = matcher.replaceAll("");

        String []str = text.split(" ");
        map = new HashMap<>(str.length, 1f);
        for (int i = 0; i < str.length; i++) {
            if(map.containsKey(str[i])){
                map.put(str[i], map.get(str[i]) + 1);
            }else
                map.put(str[i], 1);
        }
        System.out.println(map);
    }
    void runB2(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество человек: ");
        int count = scanner.nextInt();
        ProcessArray.run(count);
    }
}
