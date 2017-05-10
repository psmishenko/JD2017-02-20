package by.it.kolenda.project.java.controller;

/**
 * Created by user on 06.05.2017.
 */
public interface Pattern {
    String LOGIN ="[a-zA-Z0-9]{5,}";
    String EMAIL ="[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.-_]+";
    String PASSWORD ="[a-zA-Z0-9]{8,}";

}
