package by.it.radivonik.jd02_05;

import java.util.Locale;
import java.util.Scanner;

/**
 * Created by Radivonik on 07.04.2017.
 */
public class TaskC {
    public void run(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String cmd = "";

        try {
            System.out.println("Введите символьный код языка (exit - выход):");
            while (!((cmd = scanner.nextLine()).toLowerCase().equals("exit"))) {
                Locale locale = new Locale(cmd);
                Language.changeLocale(locale);
                System.out.println(locale.getCountry());
                (new TaskA()).run(args);
                (new TaskB()).run(args);
            }
        }
        finally {
            if (scanner != null)
                scanner.close();
        }
    }
}
