package by.it.loktev.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

public class Hello {

    public static void main(String[] args) {
        ResourceBundle resourceBundle=ResourceBundle.getBundle("by.it.loktev.jd02_05.messages",new Locale("ru","RU"));
        System.out.println(resourceBundle.getString("Main.welcome"));
    }

}
