package by.it.smirnov.jd01_13_matlab.Streams;

/**
 * Created by aleksey.smirnov on 16.03.2017.
 */
public class StringStream  implements IStream {
    private String value;
    public StringStream () {
    }

    public StringStream (String value) {
        this.value = value;
    }
    @Override
    public void load() {

    }

    @Override
    public String get() {
        return value;
    }

    @Override
    public void set(String value) {
        this.value = value;
    }

    @Override
    public void save() {

    }
}
