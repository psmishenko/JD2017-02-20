package by.it.radivonik.jd01_12;

import java.util.*;

/**
 * Created by Radivonik on 20.03.2017.
 */

// Описание класса для задания С2
public class MySet<T> {
    public Set<T> getUnion(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<T>(a);
        res.addAll(b);
        return res;
    }

    public Set<T> getCross(Set<T> a, Set<T> b) {
        Set<T> res2 = new HashSet<T>(a);
        res2.retainAll(b);
        return res2;
    }
}
