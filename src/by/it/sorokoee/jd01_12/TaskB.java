package by.it.sorokoee.jd01_12;


import java.util.*;

public class TaskB {


    void runB1() {
        Map<String, Integer> hashMap = new HashMap<>();
        String[] slova = Text.tekst.split("[^a-zA-z0-9]+");
        for (int i = 0; i < slova.length; i++) {
            Integer counter = hashMap.get(slova[i]);
            hashMap.put(slova[i], counter == null ? 1 : counter + 1);
        }
        System.out.println("Количество повторов для каждого слова " + hashMap);
    }

    void processArray(int n) {
        Timer timer = new Timer();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        int count = 0;
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;
                }
            } else {
                it = list.iterator();
            }
        }
        System.out.println(timer);
        System.out.println("Оставшийся элемент после кругового удаления " + list);
    }

    void processLinked(int n) {
        Timer timer = new Timer();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i + 1);
        }
        System.out.println(list);
        int count = 0;
        Iterator<Integer> it = list.iterator();
        while (list.size() > 1) {
            if (it.hasNext()) {
                it.next();
                count++;
                if (count == 2) {
                    it.remove();
                    count = 0;
                }
            } else {
                it = list.iterator();
            }
        }
        System.out.println(timer);
        System.out.println("Оставшийся элемент после кругового удаления " + list);
    }
}







