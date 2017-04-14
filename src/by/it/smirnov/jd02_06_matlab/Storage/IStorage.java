package by.it.smirnov.jd02_06_matlab.Storage;

import by.it.smirnov.jd02_06_matlab.Vars.Var;

/**
 * Интерфейс хранилиша переменных и их значений
 */
public interface IStorage {
    /**
     * Функция чтения переменных из файла
     * @param fileName имя файла
     */
    void loadFromFile(String fileName);
    /**
     * Функция записи переменных в файл
     * @param fileName имя файла
     */
    public void saveToFile(String fileName);
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
