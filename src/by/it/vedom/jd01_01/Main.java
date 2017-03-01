package by.it.vedom.jd01_01;

/**
 * Created by Владислав on 25.02.2017.
 */
public class Main {
    public static void main(String[] args) {

        MyFirstClass myFirstClass = new MyFirstClass();

        myFirstClass.setSlogan("Hello World");
        myFirstClass.printSlogan();

        myFirstClass.setSlogan("Привет мир!");
        myFirstClass.printSlogan();

        // демонстрация аргументов
        new printArgs().showArgs(args);
    }
}
