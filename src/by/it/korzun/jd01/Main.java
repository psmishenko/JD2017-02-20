package by.it.korzun.jd01;

public class Main {

    public static void main(String[] args) {
	System.out.println("Hello World");
	System.out.println("Next line");
    System.out.println("");
    System.out.println("---------------------------------------");

    MyFirstClass myFirstClass = new MyFirstClass();
    myFirstClass.setSlogan("Hello world");
    myFirstClass.setSlogan("Привет мир");
    myFirstClass.printSlogan();

    PrintArgs.printArgs(args);
    }
}
