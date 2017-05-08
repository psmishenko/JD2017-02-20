package by.it.psmishenko.project.java.controller;

/**
 * Created by GN on 06.05.2017.
 */
 interface Pattern {
     // user
     String LOGIN = "[a-zA-Z0-9]{5,}";
    String EMAIL = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.-_]+";
    String PASSWORD = "[a-zA-Z0-9]{5,}";
    // book
    String AUTHOR = "[a-zA-Z.]+";
    String TITLE = "[a-zA-Z]+";
    String ISBN = "[0-9.-]+";
    String YEAR = "[0-9]+";
    String LID  = "[0-9.-]+";
}
