package by.it.sorokoee.jd01_05.math;

import static java.lang.Math.*;


public class Task3 {
    public static void printTable(double x){
        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
        for (double c =-10; c <=1; c+=0.5){
            double l=pow(abs(pow((2*x-c),3)),1/5)+0.567;
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", c, "┃", l, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
    }

}
