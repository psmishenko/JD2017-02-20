package by.it.Zyryanov.jd02_06;

/**
 * Created by georgijzyranov on 24.04.17.
 */
public class Singleton {

    private static Singleton instance;

    private Singleton() {

    }

    public static Singleton getInstance() {
        if (instance == null)
        instance = new Singleton();
        return instance;
    }
}
