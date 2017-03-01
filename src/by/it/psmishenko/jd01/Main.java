package by.it.psmishenko.jd01;

public class Main {

    public static void main(String[] args) {
       MyFirstClass myFirstClass = new MyFirstClass();
       myFirstClass.setSlogan("Hello world");
       myFirstClass.printSlogan();
       myFirstClass.setSlogan("Привет мир!");
       myFirstClass.printSlogan();
       //  new
       new PrintArgs().showArgs(args);
       // second
        MySecondClass mSC = new MySecondClass();
        MySecondClass.printESlogan();

    }
}
