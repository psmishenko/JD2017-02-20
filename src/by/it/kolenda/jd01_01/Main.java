package by.it.kolenda.jd01_01;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyFirstClass  ob=new MyFirstClass();
        ob.setSlogan("hello world!");
        ob.printSlogan();

        ob.setSlogan("привет мир!");
        ob.printSlogan();

        PrintArgs.printArgs(args);

         }
}
