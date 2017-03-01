package by.it.smirnov.jd01_02;

/**
 * Created by aleksey.smirnov on 26.02.2017.
 */
public class TaskB {
    /**
     * Функция определения принадлежности некоторого значения k интервалу [n, m].
     * @version 1.0.0
     * @param k значение
     * @param n значение начала интервала
     * @param m значение конца интервала
     * @return boolean
     */
    public static boolean getAccessoryInterval(int k, int n, int m ) {
        return ((k>=n) && (k<=m));
    }

    /**
     * Функция возврата названия месяца, соответствующего данному числу.
     * Осуществить проверку корректности ввода чисел.
     * @version 1.0.0
     * @param n номер месяца
     * @return наименование месяца
     */
    public static String getMonthName(int n) {
        String[] nameMonth = {"январь", "февраль", "март",
                "апрель", "май", "июнь",
                "июль", "август", "сентябрь",
                "октябрь", "ноябрь", "декабрь"};
        if ((n < 1) || (n > 12)) {
            return "Ошибка ввода номера месяца";
        } else {
            return nameMonth[n-1];
        }
    }

    /**
     * Функция печати числа от 1 до k в виде матрицы N x N слева направо и сверху вниз
     * (k должно быть квадратом целого числа)
     * @version 1.0.0
     * @param k значение int
     */
    public static void printArray(int k) {
        int n = (int)Math.sqrt(k);
        for (int i = 1; i <= n*n; i++) {
            System.out.print( String.format("%5d",i) + " ");
            if  (i%n == 0) System.out.println();
        }
    }


    /**
     * Функция нахождения корней квадратного уравнения
     * @version 1.0.0
     * @param a значение a (ax2+bx+c+=0)
     * @param b значение b (ax2+bx+c+=0)
     * @param c значение c (ax2+bx+c+=0)
     * @return строка с решениями
     */
    public static String getSolutionQuadraticEquation(double a,double b,double c) {
        if (a==0) {
            return "a не может быть равно 0";
        } else {
            double d = b*b - 4*a*c;
            if (d < 0) {
                return "Уравнение не имеет вещественных корней";
            } else if (d == 0) {
                return "Уравнение имеет один корень: " + (-1)*b/(2*a);
            } else {
                return "Уравнение имеет два корня x1 = "+((-1)*b+Math.sqrt(d))/(2*a)+" и x2 = "+((-1)*b-Math.sqrt(d))/(2*a);
            }
        }
    }

}
