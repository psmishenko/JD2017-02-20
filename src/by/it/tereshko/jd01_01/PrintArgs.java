package by.it.tereshko.jd01_01;

public class PrintArgs {
    public static void printArgs(String[] args) {
        for (String arg : args) {
            System.out.printf("Аргумент ==> %s%n", arg);
        }
    }
}
