package by.it.psmishenko.jd01_12;

import java.util.*;

/**
 * Created by GN on 23.03.2017.
 */
public class TaskC {
    void runC1(){
        Map<Integer,String> objectsList = new TreeMap<>();
        String[] nameList = {"Бритва","Бритва","Бритва","Ручка","Ручка","Ножницы","Ноутбук","Ноутбук","Ноутбук","Ноутбук",
        "Газета","Газета","Газета","Газета","Игрушка","Игрушка"};
        for (int i = 0; i <nameList.length ; i++)   {objectsList.put( (int)(Math.random()*1000),nameList[i]);}
        System.out.println("Перечень элементов:   "+objectsList+"   Всего элементов:"+objectsList.size());
        Iterator<Map.Entry<Integer,String>> it = objectsList.entrySet().iterator();
        Set<String> hs = new HashSet<>();
        System.out.print("Производим сжатие списка");
        while (it.hasNext()){
            if(!hs.add(it.next().getValue())){
                it.remove();
            }
        }
        System.out.println("\nПеречень элементов:   "+objectsList+"   Всего элементов:"+objectsList.size());
    }

    <T> void runC2(Set<T> a,Set<T> b){
        MyCollect mc = new MyCollect();
        System.out.println("a="+a);
        System.out.println("b="+b);
        System.out.println("aUb"+mc.getUnionV2(a,b));
        System.out.println("a_b"+mc.getCrossV2(a,b));
    }
}
