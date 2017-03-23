package by.it.psmishenko.jd01_12;

import java.util.*;

/**
 * Created by GN on 23.03.2017.
 */
public class TaskC {
    void runC1(){
        Map<Integer,String> hm = new HashMap<>();
        Map<Integer,String> tm = new TreeMap<>();
        String[] str = {"Hleb","Moloko","Smetana","Moloko","Baton","Hleb"};
        for (int i = 0; i <str.length ; i++) {
            hm.put((int)(Math.random()*1000),str[i]);
            tm.put((int)(Math.random()*1000),str[i]);
        }
        System.out.println("Неупорядоченный список: "+hm+"   Всего элементов:"+hm.size());
        System.out.println("Упорядоченный список:   "+tm+"   Всего элементов:"+tm.size());

    }
    <T extends Number> void runC2(int aSize, int bSize){
        Set<T> a = new HashSet<>();
        Set<T> b = new HashSet<>();

    }

}
