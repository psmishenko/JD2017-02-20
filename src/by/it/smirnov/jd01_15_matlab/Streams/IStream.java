package by.it.smirnov.jd01_15_matlab.Streams;

/**
 * Интерфейс хранилиша переменных и их значений
 */
public interface IStream {
    void load();
    String get();
    void set(String value);
    void save();
}
