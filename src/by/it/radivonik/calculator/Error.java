package by.it.radivonik.calculator;

/**
 * Created by Radivonik on 13.03.2017.
 */
public class Error {
    public Error(String message) {
        System.out.flush();
        System.err.println(message);
    }
}
