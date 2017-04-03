package by.it.smirnov.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Класс функций для работы с множествами
 * @version 1.0.0
 */
public class MyCollect {
    /**
     * Функция, cоздающая множество, являющееся объединением множеств (а и b)
     * @version 1.0.0
     * @param a множество
     * @param b множество
     * @return объединенное множество a и b
     */
    static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        res.addAll(a);
        return res;
    }
    /**
     * Функция, cоздающая множество, являющееся пересечением множеств (а и b)
     * @version 1.0.0
     * @param a множество
     * @param b множество
     * @return множество с перечениями a и b
     */
    static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(b);
        res.retainAll(a);
        return res;
    }

}
