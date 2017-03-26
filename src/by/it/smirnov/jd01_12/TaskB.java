package by.it.smirnov.jd01_12;

import java.util.*;

/**
 * Класс задач уровня B
 * @version 1.0.0
 */
public class TaskB {
    private static final String songJingleBells=
            "Dashing through the snow\n" +
            "In a one-horse open sleigh,\n" +
            "Over the fields we go,\n" +
            "Laughing all the way;\n" +
            "Bells on bob-tail ring,\n" +
            "Making spirits bright,\n" +
            "What fun it is to ride and sing\n" +
            "A sleighing song tonight, O\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "A day or two ago,\n" +
            "I thought I'd take a ride,\n" +
            "And soon Miss Fanny Bright\n" +
            "Was seated by my side;\n" +
            "The horse was lean and lank;\n" +
            "Mis fortune seemed his lot;\n" +
            "He got into a drifted bank,\n" +
            "And we, we got upset. O\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "A day or two ago,\n" +
            "The story I must tell\n" +
            "I went out on the snow\n" +
            "And on my back I fell;\n" +
            "A gent was riding by\n" +
            "In a one-horse open sleigh,\n" +
            "He laughed as there\n" +
            "I sprawling lie,\n" +
            "But quickly drove away, O\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "Now the ground is white\n" +
            "Go it while you're young,\n" +
            "Take the girls tonight\n" +
            "And sing this sleighing song;\n" +
            "Just get a bob-tailed bay\n" +
            "Two-forty as his speed\n" +
            "Hitch him to an open sleigh\n" +
            "And crack! you'll take the lead, O\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh\n" +
            "Jingle bells, jingle bells,\n" +
            "jingle all the way!\n" +
            "O what fun it is to ride\n" +
            "In a one-horse open sleigh";

    /**
     * Функция выводит все различные слова. Для каждого слова считает частоту его встречаемости.
     * Слова, отличающиеся регистром букв, считает различными.
     * @version 1.0.0
     */
    static void runB1() {
        String[] words= songJingleBells.split("[\\s\\n\\p{Punct}а-яА-ЯёЁ]+");
        System.out.println("Общее количество слов: " + words.length);
        Map<String,Integer> map = new HashMap<>(words.length);
        for (String word : words) {
            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else
                map.put(word, 1);
        }
        System.out.println("Количество повторений слов: " + map);
    }

    /**
     * Функция для задачи расчета оставшегося элемента (Задача runB2). Реализация через ArrayList
     * @version 1.0.0
     * @param countElements первоначальное кол-во
     */
    private static void processArray(int countElements) {
        List<Integer> list = new ArrayList<>(countElements);
        for (int i = 1; i <= countElements; i++) list.add(i);
        //System.out.println("processArray: " + list);
        int i = 0;
        while (list.size() > 1) {
            ListIterator<Integer> itr = list.listIterator();
            while (itr.hasNext()) {
                itr.next();
                if (i == 1) itr.remove();
                i = (i==0) ? 1 : 0;
            }
        }
        System.out.println("processArray оставшийся элемент: " + list);
    }

    /**
     * Функция для задачи расчета оставшегося элемента (Задача runB2). Реализация через LinkedList
     * @version 1.0.0
     * @param countElements первоначальное кол-во
     */
    private static void processLinked(int countElements) {
        List<Integer> list = new LinkedList<Integer>();
        for (int i = 1; i <= countElements; i++) list.add(i);
        //System.out.println("processLinked: " + list);
        int i = 0;
        while (list.size() > 1) {
            ListIterator<Integer> itr = list.listIterator();
            while (itr.hasNext()) {
                itr.next();
                if (i == 1) itr.remove();
                i = (i==0) ? 1 : 0;
            }
        }
        System.out.println("processLinked оставшийся элемент: " + list);

    }

    /**
     * Функция расчета оставшегося элемента задачи. Задача: В кругу стоят N человек, пронумерованных от 1 до N.
     * При ведении счета по кругу вычеркивается каждый второй человек, пока не останется один.
     * @version 1.0.0
     * @param countElements первоначальное кол-во
     */
    static void runB2(int countElements) {
        long startTime = System.nanoTime();
        processArray(countElements);
        long endTime = System.nanoTime();
        System.out.printf("Время выполнения: %5.2f микросекунд\n", (endTime - startTime)/1000f);

        startTime = System.nanoTime();
        processLinked(countElements);
        endTime = System.nanoTime();
        System.out.printf("Время выполнения: %5.2f микросекунд\n", (endTime - startTime)/1000f);
    }

    /**
     * Функция расчета оставшегося элемента задачи. Задача: В кругу стоят N человек, пронумерованных от 1 до N.
     * При ведении счета по кругу вычеркивается каждый второй человек, пока не останется один.
     * Функция с использованием собственного итератора
     * @version 1.0.0
     * @param countElements первоначальное кол-во
     */
    void runB2NewIterator(int countElements) {
        long startTime = System.nanoTime();

        List<Integer> list = new ArrayList<Integer>(countElements) {
            @Override
            public Iterator<Integer> iterator() {
                IteratorByTwo itr = new IteratorByTwo();
                itr.init(this);
                return itr;
            }
        };
        for (int i = 1; i <= countElements; i++) list.add(i);
        Iterator<Integer> itr = list.iterator();

        while (itr.hasNext()) {
            itr.next();
            itr.remove();
        }

        System.out.println("\"ArrayList с собственным итератором\" оставшийся элемент: [" + list.get(0) + "]");
        long endTime = System.nanoTime();
        System.out.printf("Время выполнения: %5.2f микросекунд\n", (endTime - startTime)/1000f);
    }

    private class IteratorByTwo implements Iterator {
        int ind;
        List<Integer> list;

        public void init(List<Integer> list){
            this.ind = -1;
            this.list=list;
        }

        @Override
        public boolean hasNext() {
            return list.size()>=2;
        }

        @Override
        public Integer next() {
            ind++;
            ind++;
            ind = ind >= list.size() ? ind-list.size() : ind;
            return list.get(ind);
        }

        @Override
        public void remove() {
            list.remove(ind);
            ind--;
            ind = ind < 0 ? list.size()-1 : ind;
        }

    }

}
