package by.it.loktev.jd01_12;

import java.util.HashSet;
import java.util.Set;

public class MyGenericCollect<T> {

    Set<T> getUnion(Set<T> a, Set<T> b){
        Set<T> res=new HashSet<>(b);
        res.addAll(a);
        return res;
    }

    Set<T> getCross(Set<T> a, Set<T> b){
        Set<T> res=new HashSet<>(b);
        res.retainAll(a);
        return res;
    }

}
