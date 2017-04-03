package by.it.smirnov.jd01_12;

import java.util.*;

/**
 * Класс задач уровня A
 * @version 1.0.0
 */
public class TaskA {
    /**
     * Функция создает список оценок учеников с помощью ArrayList, заполнить случайными оценками (1-10). Удаляет
     * неудовлетворительные оценки из списка (1-4). Выводит на консоль оба варианта.
     * @version 1.0.0
     */
    static void runA1() {
        List<Integer> table = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int)Math.round(Math.random()*9+1);
            table.add(value);
        }
        System.out.println("Оценки: " + table);

        Integer[] bad = new Integer[]{1,2,3};
        List<Integer> badCollect = new ArrayList<>(Arrays.asList(bad));
        table.removeAll(badCollect);

        System.out.println("Положительные оценки: " + table);
    }

    /**
     * Функция определят два множества (A и B) на основе целых чисел. Создает множество, являющееся объединением
     * множеств (А и В)
     * @version 1.0.0
     */
    static void runA2() {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Integer value = (int)Math.round(Math.random()*9+1);
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Integer value = (int)Math.round(Math.random()*9+1);
            b.add(value);
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("a и b =" + MyCollect.getUnion(a,b));
    }

    /**
     * Функция определят два множества (A и B) на основе целых чисел. Создает множество, являющееся пересечением
     * множеств (А и В)
     * @version 1.0.0
     */
    static void runA2_1() {
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Integer value = (int)Math.round(Math.random()*9+1);
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Integer value = (int)Math.round(Math.random()*9+1);
            b.add(value);
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        System.out.println("a и b =" + MyCollect.getCross(a,b));
    }

    /**
     * Функция определят множество целых чисел и переставляет отрицательные элементы списка в конец,
     * а положительные — в начало
     * @version 1.0.0
     */
    static void runA3() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            Integer value = (int)Math.round(Math.random()*10-5);
            list.add(value);
        }
        System.out.println("list =" + list);
        Comparator<Integer> c= new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return (-1)*o1.compareTo(o2);
            }
        };
        Collections.sort(list, c);

        System.out.println("list =" + list);
    }


}
