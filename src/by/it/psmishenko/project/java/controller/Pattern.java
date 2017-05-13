package by.it.psmishenko.project.java.controller;


 interface Pattern {
     // user
     String LOGIN = "[a-zA-Z0-9]{5,}";
    String EMAIL = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9.-_]+\\.[a-zA-Z0-9.-_]+";
    String PASSWORD = "[a-zA-Z0-9]{5,}";
    // book
    String AUTHOR = "[a-zA-Zа-яА-Я.\\p{Blank}]+";
    String TITLE = "[a-zA-Zа-яА-Я0-9\\p{Punct}\\p{Blank}]+";
    String ISBN = "[0-9-]+";
    String LID  = "[0-9]+";
}
