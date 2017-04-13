package by.it.korzun.matlab;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ConsoleRunner {
    static Long startTime;
    static List<String> operations = new ArrayList<>();
    static List<String> allAndFullOperations = new ArrayList<>();

    static List<String> getOperations() {
        return operations;
    }

    static List<String> getAllAndFullOperations() {
        return allAndFullOperations;
    }

    public static void main(String[] args) throws MathException {
        startTime = System.currentTimeMillis();
        Date date;
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Var.load();
        Var res;
        System.out.printf("Введите выражение(или:\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s\n%-10s - %-20s):\n",
                "save", "сохранить новые переменные",
                "sae", "сохранить и выйти(!Без этой комманды все новые данные будут потеряны!)",
                "saef", "сохранить, вывести полный отчёт и выйти",
                "saes", "сохранить, вывести краткий отчёт и выйти",
                "printvar", "вывести все созданные переменные",
                "sortvar", "сортировать и вывести");
        Waiter waiter = new Waiter();
        label:
        while (true) {
            try {
                String str = scanner.nextLine();
                switch (str) {
                    case "sae":
                        Var.saveOnExit();
                        scanner.close();
                        break label;
                    case "saef":{
                        waiter.setReportBuilder(new FullReportBuilder());
                        waiter.constructReport();
                        System.out.println(waiter.getReport());
                        scanner.close();
                        break label;
                    }
                    case "saes":{
                        waiter.setReportBuilder(new ShortReportBuilder());
                        waiter.constructReport();
                        System.out.println(waiter.getReport());
                        scanner.close();
                        break label;
                    }
                    case "printvar":
                        System.out.println(Var.getVars());
                        break;
                    case "sortvar":
                        Var.sortVars();
                        System.out.println(Var.getVars());
                        break;
                    default:
                        res = parser.parseString(str, false);
                        String timeOut;
                        date = new Date();
                        timeOut = String.format("%-2d:%-2d:%-2d",date.getHours(),date.getMinutes(),date.getSeconds());
                        if(str.contains("=")){
                            operations.add(str);
                            allAndFullOperations.add(timeOut + " - " + str);
                        }else {
                            operations.add(str + " = " + res.toString());
                            allAndFullOperations.add(timeOut + " : " + str + " = " + res.toString());
                        }
                        break;
                }
            } catch (Exception e) {

            }

        }

    }
}
