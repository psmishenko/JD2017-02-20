package by.it.prigozhanov.project.java.controller;

/**
 * Created by v-omf on 5/6/2017!
 */
public interface Pattern {
    String LOGIN = "[a-zA-Z0-9]{5,}";
    String EMAIL = "[a-zA-Z0-9.-_]+@[a-zA-Z0-9]+.[a-zA-Z]{2,4}";
    String PASSWORD = "[a-zA-Z0-9]{8,}";
    String TELEPHONE = "\\+[0-9]{12}";
    String CARDNUMBER = "(([A-Za-z0-9]{4})-){3}[A-Za-z0-9]{4}";
    String INTEGER = "[0-9]+";
    String PASSPORT = "[A-Z]{2,}[0-9]{7,}";


}
