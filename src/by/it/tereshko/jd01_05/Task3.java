package by.it.tereshko.jd01_05;

import static java.lang.Math.*;

public class Task3 {
    public static void printTable (){
        double x = 12.1;
        System.out.println("┌────────────────────────────────┐");
        System.out.println("│  param  │        value         │");
        System.out.println("│─────────│──────────────────────│");
        for (double c = -10; c <= 1; c += 0.5) {
            double l = pow(pow((2*x - c), 3), 0.2) + 0.567;
            System.out.println(String.format("%-4s%-6s%-2s%-21s%-22s", "│", c, "│", l, "│"));
        }
        System.out.println("└────────────────────────────────┘");
    }
}
