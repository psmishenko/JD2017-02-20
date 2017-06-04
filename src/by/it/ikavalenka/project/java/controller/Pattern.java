package by.it.ikavalenka.project.java.controller;

/**
 * Created by user on 06.05.2017.
 */
public interface Pattern {
    String LOGIN ="[0-9]+";
    String PASSWORD ="[0-9]+";
    String CATALOG ="[a-zA-Z0-9]{8,}";
    String ORDER ="[a-zA-Z0-9]{8,}";
    String BLACKLIST ="[a-zA-Z0-9]{8,}";
}
