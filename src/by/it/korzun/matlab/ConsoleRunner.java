package by.it.korzun.matlab;

import java.util.Scanner;

public class ConsoleRunner {

    public static void main(String[] args) throws MathException {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Var.load();
        System.out.printf("Введите выражение(или:\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s):\n","save", "сохранить новые переменные",
                "sae", "сохранить и выйти(!Без этой комманды все новые данные будут потеряны!)", "printvar", "вывести все созданные переменные",
                "sortvar", "сортировать и вывести");
        label:
        while (true) {
            try {
                String str = scanner.nextLine();
                switch (str) {
                    case "sae":
                        Var.saveOnExit();
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
                        parser.parseString(str, false);
                        break;
                }
            } catch (Exception e) {
                new MathException("Некорректный ввод");
            }

        }

    }
}
