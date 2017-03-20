package by.it.loktev.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyCollect {

    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> res=new HashSet<>(b);
        res.addAll(a);
        /*
        for ( Integer value : a ){
            if ( !b.contains(value) )
                res.add(value);
        }
        */
        return res;
    }

    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b){
        Set<Integer> res=new HashSet<>(b);
        res.retainAll(a);
        /*
        Set<Integer> res=new HashSet<>();
        for ( Integer value : a ){
            if ( b.contains(value) )
                res.add(value);
        }
        */
        return res;
    }

}
