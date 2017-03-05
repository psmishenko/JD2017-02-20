package by.it.ikavalenka.jd_05;

/**
 * Created by USER on 03.03.2017.
 */
public class TaskC {
    public static void printTabl() {
        double x = 12.1;
        System.out.println("|-------|-----------------------|");
        System.out.println("| param |     value             |");
        System.out.println("|-------|-----------------------|");
            for (double a = 3.75;-5<=a;a +=3.75){
                if (a<=12){
                    double y = Math.pow(Math.E,a*x)-3.45*a;
                    System.out.println(String.format("%-2s%-6s%-2s%-19s%-20s","|",a, "|",y,"|"));
                    System.out.println("|-------|----------------------|");
                }


        }


    }
}
