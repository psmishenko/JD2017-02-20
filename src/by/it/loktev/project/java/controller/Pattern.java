package by.it.loktev.project.java.controller;

public interface Pattern {

    String LOGIN="[A-Za-z0-9]{5,}";
    String EMAIL="[A-Za-z0-9.-_]+@([A-Za-z0-9.-_]+\\.)+[A-Za-z0-9.-_]+";
    String PASSWORD="[A-Za-z0-9]{4,}";

    String FLOAT="\\d+(?:\\.\\d+)?";
    String DATE="\\d{4}\\-\\d{2}\\-\\d{2}";

    String TASKNAME=".{5,}";

}
