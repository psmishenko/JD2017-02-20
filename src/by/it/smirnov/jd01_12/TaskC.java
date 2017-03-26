package by.it.smirnov.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Класс задач уровня C (задача С1 и С2)
 * @version 1.0.0
 */
public class TaskC {

    /**
     * Функция определят два множества (A и B) на основе целых чисел.
     * Создает множество, используя Generics-функции, являющееся объединением множеств (А и В)
     * @version 1.0.0
     */
    static void runC2UnionInteger() {
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
        MyCollectGen<Integer> myCollect = new MyCollectGen<>();
        System.out.println("a и b =" + myCollect.getUnion(a,b));
    }

    /**
     * Функция определят два множества (A и B) на основе вещественных чисел.
     * Создает множество, используя Generics-функции, являющееся объединением множеств (А и В)
     * @version 1.0.0
     */
    static void runC2UnionDouble() {
        Set<Double> a = new HashSet<>();
        Set<Double> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Double value = Math.random()*9+1;
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Double value = Math.random()*9+1;
            b.add(value);
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        MyCollectGen<Double> myCollect = new MyCollectGen<>();
        System.out.println("a и b =" + myCollect.getUnion(a,b));
    }

    /**
     * Функция определят два множества (A и B) на основе целых чисел.
     * Создает множество, используя Generics-функции, являющееся пересечением множеств (А и В)
     * @version 1.0.0
     */
    static void runC2CrossInteger() {
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
        MyCollectGen<Integer> myCollect = new MyCollectGen<>();
        System.out.println("a и b =" + myCollect.getCross(a,b));
    }

    /**
     * Функция определят два множества (A и B) на основе вещественных чисел.
     * Создает множество, используя Generics-функции, являющееся пересечением множеств (А и В)
     * @version 1.0.0
     */
    static void runC2CrossDouble() {
        Set<Double> a = new HashSet<>();
        Set<Double> b = new HashSet<>();
        for (int i = 0; i < 4; i++) {
            Double value = Math.random()*9+1;
            a.add(value);
        }
        for (int i = 0; i < 6; i++) {
            Double value = Math.random()*9+1;
            b.add(value);
        }
        System.out.println("a=" + a);
        System.out.println("b=" + b);
        MyCollectGen<Double> myCollect = new MyCollectGen<>();
        System.out.println("a и b =" + myCollect.getCross(a,b));
    }

    /**
     * Функция проверки выражения̆ на корректность расстановки скобок ( «(», «)», «[», «]», «{», «}»).
     * @version 1.0.0
     * @param value выражение
     * @return true, если скобки расставлены верно. В противном случае false
     */
    static boolean checkStr(String value) {
        LinkedList<String> stack = new LinkedList<>();
        Pattern pat=Pattern.compile("[\\{\\}\\[\\]\\(\\)]");
        Matcher matcher=pat.matcher(value);
        boolean isError = false;
        while (matcher.find()) {
            String subStr = matcher.group();
            switch (subStr){
                case "{" :
                case "[" :
                case "(" :
                    stack.addLast(subStr);
                    break;
                case "}" : isError = !stack.getLast().equals("{");
                    break;
                case "]" : isError = !stack.getLast().equals("[");
                    break;
                case ")" : isError = !stack.getLast().equals("(");
                    break;
            }
            if (isError) break;
            switch (subStr){
                case "}" :
                case "]" :
                case ")" : stack.removeLast();
                    break;
            }
            }
        return !isError && (stack.size()==0);
    }

}
