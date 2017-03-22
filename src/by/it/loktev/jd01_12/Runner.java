package by.it.loktev.jd01_12;

import java.util.HashMap;
import java.util.TreeMap;

public class Runner {

    public static void main(String[] args) {
/*
        TaskA taskA=new TaskA();
        System.out.println("=== A1");
        taskA.runA1();
        System.out.println("=== A2");
        taskA.runA2();
        System.out.println("=== A3");
        taskA.runA3();
        */

        TaskB taskB=new TaskB();
        System.out.println("=== B1");
        int hashTime1=taskB.runB1(new HashMap<String,Integer>());
        int hashTime2=taskB.runB1(new HashMap<String,Integer>());
        int treeTime1=taskB.runB1(new TreeMap<String,Integer>());
        int treeTime2=taskB.runB1(new TreeMap<String,Integer>());
        System.out.println("Время работы с HashMap, замер 1: "+hashTime1+" мс");
        System.out.println("Время работы с HashMap, замер 2: "+hashTime2+" мс");
        System.out.println("Время работы с TreeMap, замер 1: "+treeTime1+" мс");
        System.out.println("Время работы с TreeMap, замер 2: "+treeTime2+" мс");
        // у TreeMap внесение изменений дольше чем у HashMap, т.е. при небольшом количестве элементов TreeMap тратит неразумно много времени на перебалансировку дерева
        // у TreeMap поиск элементов обычно быстрее чем у HashMap, но при небольшом количестве повторений слов TreeMap не успевает проявить эффективность
        // поэтому, в данной задаче HashMap выигрывает
        //System.out.println("=== B2");
        //taskB.runB2();

/*
        TaskC taskC=new TaskC();
        System.out.println("=== C1");
        taskC.runC1();
        System.out.println("=== C2");
        taskC.runC2(8,true);
        System.out.println("=== C3");
        taskC.runC3();
*/

    }

}
