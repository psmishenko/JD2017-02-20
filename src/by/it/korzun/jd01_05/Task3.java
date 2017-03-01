package by.it.korzun.jd01_05;
import static java.lang.Math.*;

class Task3 {
    static void run() {
        System.out.println("Task 3: ");

        System.out.println("┏━━━━━━━┳━━━━━━━━━━━━━━━━━━━━┓");
        System.out.println("┃ param ┃        value       ┃");
        System.out.println("┣━━━━━━━╋━━━━━━━━━━━━━━━━━━━━┫");
        for (double t = 2; t <= 3; t += 0.1){
            double s = log(abs(1.3 + t)) - pow(E, 2);
            System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s", "┃", t, "┃", s, "┃"));
        }
        System.out.println("┗━━━━━━━┻━━━━━━━━━━━━━━━━━━━━┛");
    }

}
