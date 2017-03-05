package by.it.radivonik.jd01_01;

/**
 * Created by Radivonik on 01.03.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyFirstClass myFirstClass = new MyFirstClass();

        myFirstClass.setSlogan("Hello, World!");
        myFirstClass.printSlogan();

        myFirstClass.setSlogan("Привет, Мир!");
        myFirstClass.printSlogan();

        new PrintArgs().showArgs(args);
    }
}
