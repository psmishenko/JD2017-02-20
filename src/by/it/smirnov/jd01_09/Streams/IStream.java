package by.it.smirnov.jd01_09.Streams;

/**
 * Created by aleksey.smirnov on 16.03.2017.
 */
public interface IStream {
    void load();
    String get();
    void set(String value);
    void save();
}
