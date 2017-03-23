package by.it.prigozhanov.jd01_12;

import java.util.*;
import java.util.regex.Pattern;

/**
 * Created by v-omf on 3/20/2017.
 *
 * @author v-omf
 */
public class TaskB {
    void runB1() {
        String[] wordArr = Text.Description.split("[^a-zA-Z]+");
        Map<String, Integer> map = new HashMap<>(1);
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        int counter = 1;
        for (int i = 0; i < wordArr.length; i++) {
            map.put(wordArr[i], 1);
        }
        for (int i = 0; i < wordArr.length; i++) {
            if (it.hasNext()) {
                if (map.containsKey(wordArr[i])) {
                    System.out.println(wordArr[i]);
                }
                counter=1;
            }
        }

    }
}
