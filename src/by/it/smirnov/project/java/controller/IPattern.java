package by.it.smirnov.project.java.controller;

/**
 * Created by aleksey.smirnov on 06.05.2017.
 */
public interface IPattern {
    String LOGIN="[a-zA-Z0-9]{5,}";
    String EMAIL="[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.-_]+";
    String PASSWORD="[a-zA-Z0-9]{8,}";
    String BIC = "[0-9]{9}";
    String VALUT = "[A-Z]{3}";
}
