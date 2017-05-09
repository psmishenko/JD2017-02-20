package by.it.prigozhanov.project.java.controller;

/**
 * Created by v-omf on 5/6/2017!
 */
public interface Pattern {
    String LOGIN= "[a-zA-Z0-9]{5,}";
    String EMAIL= "[a-zA-Z0-9.-_]+[a-zA-Z0-9]{5,}";
    String PASSWORD= "[a-zA-Z0-9]{8,}";


}
