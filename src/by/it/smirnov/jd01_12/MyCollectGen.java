package by.it.smirnov.jd01_12;

import java.util.HashSet;
import java.util.Set;

/**
 * Generics класс функций для работы с множествами
 * @version 1.0.0
 */
public class MyCollectGen<T> {
    /**
     * Generics функция, cоздающая множество, являющееся объединением множеств (а и b)
     * @version 1.0.0
     * @param a множество
     * @param b множество
     * @return объединенное множество a и b
     */
    Set<T> getUnion(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(b);
        res.addAll(a);
        return res;
    }
    /**
     * Generics функция, cоздающая множество, являющееся пересечением множеств (а и b)
     * @version 1.0.0
     * @param a множество
     * @param b множество
     * @return множество с перечениями a и b
     */
    Set<T> getCross(Set<T> a, Set<T> b) {
        Set<T> res = new HashSet<>(b);
        res.retainAll(a);
        return res;
    }
}
