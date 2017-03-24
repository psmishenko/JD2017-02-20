package by.it.smirnov.jd01_13_matlab.Storage;

import by.it.smirnov.jd01_13_matlab.Vars.Var;

/**
 * Интерфейс хранилиша переменных и их значений
 */
public interface IStorage {
    /**
     * Функция добавления значения в карту
     * @param key ключ
     * @param value значение
     */
    void setMap(String key, Var value);
    /**
     * Функция получения значения из карты по ключу
     * @param key ключ
     */
    Var getValue(String key);
    /**
     * Печать списка переменных
     */
    String getListKey();
    /**
     * Печать списка переменных и их значений
     */
    String getSortListKeyValue();
}
