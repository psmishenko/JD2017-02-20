package by.it.korzun.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollectGen<T extends Number> {

    void getUnionGen(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>(b);
        res.addAll(a);
        System.out.println("Объединение: " + res);
    }

    void getCrossGen(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>();
        res.addAll(a);
        res.retainAll(b);
        System.out.println("Пересечение: " + res);
    }
}
