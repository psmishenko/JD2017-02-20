package by.it.korzun.project.java.controller;

public interface Pattern {
    String NAME = "[a-zA-Z]{3,}";
    String LOGIN = "[a-zA-Z0-9]{5,}";
    String PASSWORD = "[a-zA-Z0-9]{5,}";
    String SPECIALIZATION = "[1-6]";
    String DESTINATION = "[a-zA-Z]+";
    String ID = "[\\d]{1,}";

}
