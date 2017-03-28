package by.it.smirnov.jd01_15_matlab.Streams;

import by.it.smirnov.jd01_15_matlab.Log.ILog;

import java.util.Scanner;

/**
 * Created by aleksey.smirnov on 16.03.2017.
 */
public class ConsoleStream implements IStream {
    private ILog log;
    public ConsoleStream (ILog log) {
        this.log = log;
    }
    private String value;
    @Override
    public void load() {
        value = new Scanner(System.in).nextLine();
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
        log.info(value);
        System.out.println(value);
        System.out.println();
    }
}
