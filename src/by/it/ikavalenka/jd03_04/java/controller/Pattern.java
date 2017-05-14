package by.it.ikavalenka.jd03_04.java.controller;

/**
 * Created by USER on 06.05.2017.
 */
public interface Pattern {

    String LOGIN = "[a-zA-Z0-9]{5,}";
    String EMAIL = " /^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$/";
    String PASSWORD = "[a-zA-Z0-9]{8,}";
}
