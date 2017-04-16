package by.it.smirnov.jd02_06_matlab.Streams;

/**
 * Интерфейс хранилиша переменных и их значений
 */
public interface IStream {
    void load();
    String get();
    void set(String value);
    void save();
}
