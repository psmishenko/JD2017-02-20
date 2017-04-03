package by.it.radivonik.jd01_12;

import java.util.*;
import java.util.regex.*;

/**
 * Created by Radivonik on 20.03.2017.
 * Класс, реализующий задания варианта C
 */
public class TaskC {
    /**
     * Метод, релизующий задание C1
     */
    public void runC1() {
        String [] names = Data.textC1.split("[^а-яА-ЯёЁ]+");
        List<C1> list1 = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            C1 c1 = new C1(names[i],(int)(Math.random()*1000000));
            list1.add(c1);
        }

        // Сортировка списка с собственном компаратором
        Comparator<C1> comp1 = new Comparator<C1>() {
            @Override
            public int compare(C1 o1, C1 o2) {
                return o1.shifr - o2.shifr;
            }
        };
        Collections.sort(list1, comp1);
        System.out.println("Отсортированный список: " + list1);

        // Копирование списка во множество для реализации сжатия
        Set<C1> list2 = new TreeSet<>(
            new Comparator<C1>() {
                @Override
                public int compare(C1 o1, C1 o2) {
                    return o1.name.compareTo(o2.name);
                }
            }
        );
        list2.addAll(list1);
        System.out.println("Сжатый список: " + list2);
    }

    /**
     * Класс, реализующий хранение наименований и шифров объектов
     */
    private class C1 {
        private String name;
        private int shifr;

        C1(String name, int shifr) {
            this.name = name;
            this.shifr = shifr;
        }

        @Override
        public String toString() {
            return shifr + " " + name;
        }
    }

    /**
     * Метод, релизующий задание C2
     */
    public void runC2() {
        MySet<Double> setD = new MySet<>();
        Set<Double> aD = new HashSet<>(Arrays.asList(new Double[]{1.0,2.0,3.0,4.5}));
        Set<Double> bD = new HashSet<>(Arrays.asList(new Double[]{5.0,2.0,4.0,4.5}));
        System.out.println("Тип Double:");
        System.out.println("Множество А: " + aD);
        System.out.println("Множество B: " + bD);
        System.out.println("Объединение множеств A и B: " + setD.getUnion(aD, bD));
        System.out.println("Пересечение множеств A и B: " + setD.getCross(aD, bD));

        MySet<String> setS = new MySet<>();
        Set<String> aS = new HashSet<>(Arrays.asList(new String[]{"мама","папа","дочка","сын","внучка","внук"}));
        Set<String> bS = new HashSet<>(Arrays.asList(new String[]{"бабушка","дедушка","мама","дочка","внучка","сестра","брат"}));
        System.out.println("Тип String:");
        System.out.println("Множество А: " + aS);
        System.out.println("Множество B: " + bS);
        System.out.println("Объединение множеств A и B: " + setS.getUnion(aS, bS));
        System.out.println("Пересечение множеств A и B: " + setS.getCross(aS, bS));
    }

    /**
     * Метод, релизующий задание C3
     */
    public void runC3() {
        String s1 = "{[234+24]}((56+5)*{34[454/(45+4)]+56}+4){0.1}";
        String s2 = "[[234+24]]((56+5)*{34[454/(45+4))+56}+4)";
        String s3 = "{([234+24}}((56+5)*{34[454/(45+4)]+56}+4)";
        String s4 = "{[234+24]]}";
        String s5 = "{[[(((234+24)))]](456[89])}";
        String s6 = "{[[(((234+24)))]](456[89])";

        checkBracketsPrint(s1);
        checkBracketsPrint(s2);
        checkBracketsPrint(s3);
        checkBracketsPrint(s4);
        checkBracketsPrint(s5);
        checkBracketsPrint(s6);
    }

    /**
     * Метод для определения корректности расстановки скобок в выражении
     * @param str выражение для проверки корректности содержащихся в нем скобок
     */
    // вспомогательные методы для 3-го задания
    private void checkBracketsPrint(String str) {
        String msg1 = "В строке %s скобки расставлены корректно\n";
        String msg2 = "В строке %s скобки расставлены некорректно, ошибка в позиции %d:\n\t%s\n";
        String msg3 = "В строке %s скобки расставлены некорректно, не хватает закрывающих скобок: %d шт.\n";
        int pos = checkBrackets(str);;
        if (pos == 0)
            System.out.printf(msg1,str);
        else if (pos > 0 )
            System.out.printf(msg2,str,pos,str.substring(0,pos-1) + "  '" + str.substring(pos-1,pos) + "'  " + str.substring(pos));
        else
            System.out.printf(msg3,str,-pos);
    }

    /**
     * Метод возвращает позицию в строке, в которой находится некорректная скобка
     *
     * @param str проверяемое выражение
     * @return 0 - скобки расставлены корректно,
     * >0- номер позиции с некорректной закрывающей скобкой (номеруется с 1-й позициии)
     * <0- количество непарных открывающих скобок
     */
    private int checkBrackets(String str) {
        String ptrBr = "[(){}\\[\\]]";  // скобки
        String ptrBrOpen = "[({\\[]";   // открывающие скобки
        String ptrBrClose = "[)}\\]]";  // закрывающие скобки

        Deque<String> exp = new LinkedList<>();
        Pattern p = Pattern.compile(ptrBr);
        Matcher m = p.matcher(str);

        while (m.find()) {
            String s = m.group();
            if (s.matches(ptrBrOpen))
                exp.addLast(s);
            else if (s.matches(ptrBrClose)) {
                if (s.equals(")") && !exp.getLast().equals("(") ||
                    s.equals("}") && !exp.getLast().equals("{") ||
                    s.equals("]") && !exp.getLast().equals("[")) {
                    return m.start()+1;
                }
                else {
                    exp.removeLast();
                }
            }
        }

        return -exp.size();
    }
}
