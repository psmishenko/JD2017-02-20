package by.it.radivonik.jd01_12;

import java.util.*;

/**
 * Created by Radivonik on 20.03.2017.
 * Класс для реализации методов объединения и пересечения множеств, состоящих из любых классов
 */

//
public class MySet<T> {
    /**
     * Метод реализующий объединение двух множеств
     *
     * @param a мнжество 1
     * @param b мнжество 2
     * @return множество - результат объединения множетва 1 и множества 2
     */
    public Set<T> getUnion(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<T>(a);
        res.addAll(b);
        return res;
    }

    /**
     * Метод реализующий пересечение двух множеств
     *
     * @param a мнжество 1
     * @param b мнжество 2
     * @return множество - результат пересечения множетва 1 и множества 2
     */
    public Set<T> getCross(Set<T> a, Set<T> b) {
        Set<T> res2 = new HashSet<T>(a);
        res2.retainAll(b);
        return res2;
    }
}
