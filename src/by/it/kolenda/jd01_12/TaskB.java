package by.it.kolenda.jd01_12;

import java.util.*;
//import static by.it.kolenda.jd01_12.Data.english;

public class TaskB {
    void runB1() {
        String[] list = Data.english.split("[^A-Za-z]+");
        List<String> collectionList=new ArrayList<>(Arrays.asList(list));
//        for (String w : list)
//            collectionList.add(w);
        System.out.println();
        System.out.println(collectionList);

        Map<String,Integer> hw=new HashMap<>();
        Collections.sort(collectionList);
        System.out.println(collectionList);

        for (String word : list) {
            int count = 1;
            if (hw.containsKey(word)) {
                count = hw.get(word) + 1;
            }
            hw.put(word, count);
        }

        System.out.print(hw);

    }
}