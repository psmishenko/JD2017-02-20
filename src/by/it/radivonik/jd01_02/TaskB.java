package by.it.radivonik.jd01_02;

/**
 * Created by Radivonik on 28.02.2017.
 */
public class TaskB {
<<<<<<< f1c030438cf71245b23b5a32fb8d20b0ebb8bca6
    public static boolean isIn(int k, int n, int m ) {
        if ( k >= n && k <= m )
            return true;
        else
            return false;
    }

    public static void printMatrix(int k) {
        int c = 0;
        int n = (int) Math.sqrt(k);
        for (int i = 1; i <= k; i++) {
            System.out.printf("%5d ",i);
            c++;
            if (c == n) {
                System.out.println();
                c = 0;
            }
        }
    }

    public static String getKorenUr(double a,double b,double c) {
        String res;
        if (a == 0) {
            double x = -c / b;
            res = "Уравнение имеет один корень x = " + x;
        }
        else {
            double d = b * b - 4 * a * c;
            if (d < 0)
                res = "Уравнение не имеет корней";
            else if (d == 0) {
                double x = -b / (2 * a);
                res = "Уравнение имеет один корень x = " + x;
            }
            else {
                double x1 = (-b + Math.sqrt(d)) / (2 * a);
                double x2 = (-b - Math.sqrt(d)) / (2 * a);
                res = "Уравнение имеет корни x1 = " + x1 +", x2 = " + x2;
            }
        }
        return res;
    }

    public static String getMonthName(int nMonth) {
=======
    static String getMonthName(int nMonth) {
>>>>>>> Тест
        String[] aMonth = {
                "январь", "февраль", "март", "апрель", "май", "июнь",
                "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"
        };

        if (nMonth < 1 || nMonth > 12)
            return "Нет такого месяца";
        else
            return aMonth[nMonth-1];
    }
}
