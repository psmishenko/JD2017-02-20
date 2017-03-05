package by.it.Zyryanov.jd01_01;

public class Main {

    public static void main(String[] args) {

        MyFirstClass ob=new MyFirstClass();
        ob.setSlogan("Hello world");
        ob.printSlogan();
        ob.setSlogan("Привет мир!");
        ob.printSlogan();
        PrintArgs.printArgs(args);
    }
}
