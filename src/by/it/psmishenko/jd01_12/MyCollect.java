package by.it.psmishenko.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by user on 20.03.2017.
 */
public class MyCollect {
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> res = new HashSet<>(b);
        res.addAll(a);
        // второй способ
//        for (Integer value:a) {
//            if(!b.contains(value))  res.add(value);
//        }
        return res;
    }
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> res = new HashSet<>();
        // первый способ
        res.addAll(a);
        res.retainAll(b);
        // второй способ
//        for (Integer value:a) {
//         if(b.contains(value))  res.add(value);
//        }
        return res;
    }
    <T> Set<T> getUnionV2(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>(b);
        res.addAll(a);
        // второй способ
//        for (Integer value:a) {
//            if(!b.contains(value))  res.add(value);
//        }
        return res;
    }
    <T> Set<T> getCrossV2(Set<T> a, Set<T> b){
        Set<T> res = new HashSet<>();
        // первый способ
        res.addAll(a);
        res.retainAll(b);
        // второй способ
//        for (Integer value:a) {
//         if(b.contains(value))  res.add(value);
//        }
        return res;
    }
}
