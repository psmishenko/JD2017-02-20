package by.it.radivonik.jd01_12;

import com.sun.deploy.util.Waiter;

import java.util.*;
import java.util.regex.*;

/**
 * Created by Radivonik on 20.03.2017.
 */
public class TaskC {
    public void runC1() {

    }

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

    public void runC3() {
        String s1 = "{[234+24]}((56+5)*{34[454/(45+4)]+56}+4)";
        String s2 = "[[234+24]]((56+5)*{34[454/(45+4))+56}+4)";
        String s3 = "{([234+24}}((56+5)*{34[454/(45+4)]+56}+4)";
        String s4 = "{[234+24]]}";
        String s5 = "{[[(((234+24)))]](456[89])}";

        checkBracketsPrint(s1);
        checkBracketsPrint(s2);
        checkBracketsPrint(s3);
        checkBracketsPrint(s4);
        checkBracketsPrint(s5);
    }

    // вспомогательные методы для 3-го задания
    private void checkBracketsPrint(String str) {
        String msg1 = "В строке %s скобки расставлены корректно\n";
        String msg2 = "В строке %s скобки расставлены некорректно, ошибка в позиции %d:\n\t%s\n";
        int pos = checkBrackets(str);;
        if (pos < 0)
            System.out.printf(msg1,str);
        else
            System.out.printf(msg2,str,pos,str.substring(0,pos) + "  '" + str.substring(pos,pos+1) + "'  " + str.substring(pos+1));
    }

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
                    return m.start();
                }
                else {
                    exp.removeLast();
                }
            }
        }

        return -1;
    }
}
