package by.it.prigozhanov.jd01_12;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/20/2017.
 *
 * @author v-omf
 */
public class TaskB {
    void runB2() {
        String[] wordArr = Text.Description.split("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<>();
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        int counter = 1;
        for (int i = 0; i < wordArr.length; i++) {
            map.put(wordArr[i], 1);
        }
        for (Map.Entry<String, Integer> s : map.entrySet()) {
            if (s.getKey().contains(s.getKey())) {
                counter += s.getValue();
                map.put(s.getKey(), counter);
            }
            counter = 1;
        }

        System.out.println(map);

    }

    void runB3() {
        List<Integer> list = new ArrayList<>();
        int n = 20;
        for (int i = 0; i < n; i++) {
            list.add(i+1);
        }
        System.out.println(list);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            it.next();
            it.remove();
            System.out.println(list);
        }
        System.out.println(list);
    }
}
