package by.it.akhmelev.project.java.controller;

public interface Pattern {

    String LOGIN="[a-zA-Z0-9]{5,}";
    String EMAIL="[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.-_]+";
    String PASSWORD="[a-zA-Z0-9]{8,}";
    String ANYSTRING=".*"; //переписать, т.к. возможна инъекция в SQL

}
