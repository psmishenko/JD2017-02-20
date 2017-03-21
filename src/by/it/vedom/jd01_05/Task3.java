package by.it.vedom.jd01_05;

import static java.lang.Math.*;

/**
 * Created by Владислав on 02.03.2017.
 */
public class Task3 {

    public static void printTable(){

        double x = 3.567;

        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━━━━━┫");
        for (double a = 3.5; a <= 25.5; a += 3.75){
            double y = (1.0 / tan(pow(x, 3))) + 2.24 * a * x;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", a, "┃", y, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━┛");
    }
}
