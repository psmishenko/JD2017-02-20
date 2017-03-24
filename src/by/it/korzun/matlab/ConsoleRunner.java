package by.it.korzun.matlab;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        System.out.println("Введите выражение(или: exit - выйти, printvar - вывести все созданные переменные, sortvar -  " +
                "\nсортировать и вывести): ");
        label:
        while (true) {
            try {
                String str = scanner.nextLine();
                switch (str) {
                    case "exit":
                        scanner.close();
                        break label;
                    case "printvar":
                        System.out.println(Var.getVars());
                        break;
                    case "sortvar":
                        Var.sortVars();
                        System.out.println(Var.getVars());
                        break;
                    default:
                        parser.parseString(str);
                        break;
                }
            } catch (Exception e) {
                new MathException("Некорректный ввод");
            }

        }

    }
}
