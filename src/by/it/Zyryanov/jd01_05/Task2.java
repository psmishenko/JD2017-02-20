package by.it.Zyryanov.jd01_05;

import static java.lang.Math.*;

public class Task2 {

//    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//    String a1 = reader.readLine();
//    double a = Double.parseDouble(a1);
//    String b1 = reader.readLine();
//    double b = Double.parseDouble(b1);





    public static void solver (double a, double b) {

        double y;

        y = pow((a + 1.5), 1/3) + pow((a-b), 8) - (b/(asin(pow(abs(a), 2))));
        System.out.println(y);
    }
}
