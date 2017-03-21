package by.it.tereshko.jd01_01;

public class Main {
    public static void main(String[] args) {

        //Создаем экземпляр класса
        MyFirstClass myFirstClass = new MyFirstClass();
        //используем два экземплярных метода
        myFirstClass.setSlogan("Привет, мир!");
        myFirstClass.printSlogan();
        myFirstClass.setSlogan("Hello, world!");
        myFirstClass.printSlogan();
        //показываем аргументы
        new PrintArgs().printArgs(args);

    }
}