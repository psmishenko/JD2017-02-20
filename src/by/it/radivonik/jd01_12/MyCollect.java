package by.it.radivonik.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Radivonik on 20.03.2017.
 * Класс для реализации методов объединения и пересечения множеств из целых чисел
 */
public class MyCollect {
    /**
     * Метод реализующий объединение двух множеств
     *
     * @param a мнжество 1
     * @param b мнжество 2
     * @return множество - результат объединения множетва 1 и множества 2
     */
    public static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        // Способ 1
        res.addAll(b);

        // Способ 2
//        for (Integer value: a) {
//            if (!b.contains(value)) {
//                res.add(value);
//            }
//        }
        return res;
    }

    /**
     * Метод реализующий пересечение двух множеств
     *
     * @param a мнжество 1
     * @param b мнжество 2
     * @return множество - результат пересечения множетва 1 и множества 2
     */
    public static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        // Способ 1
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;

        // Способ 2
//        Set<Integer> res = new HashSet<>();
//        for (Integer value: a) {
//            if (b.contains(value)) {
//                res.add(value);
//            }
//        }
//        return res;
    }
}
