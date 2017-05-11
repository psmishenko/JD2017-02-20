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
    String AUTHOR = "[a-zA-Zа-яА-Я.\\p{Blank}]+";
    String TITLE = "[a-zA-Zа-яА-Я0-9\\p{Punct}\\p{Blank}]+";
    String ISBN = "[0-9-]+";
    String YEAR = "[0-9]{1,4}";
    String LID  = "[0-9]+";
}
