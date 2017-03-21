package by.it.vedom.jd01_02;

/**
 * Created by Владислав on 25.02.2017.
 */
public class TaskB {

    //Поиск принадлежности K интервалу от N до M
    static boolean accessory(double n, double m, double k) {

        if (k >= n && k <= m)
            return true;
        else return false;
    }

    static String nameMonth(int number) {
        String month;
        switch (number) {
            case 1:
                month = "Январь";
                break;
            case 2:
                month = "Февраль";
                break;
            case 3:
                month = "Март";
                break;
            case 4:
                month = "Апрель";
                break;
            case 5:
                month = "Май";
                break;
            case 6:
                month = "Июнь";
                break;
            case 7:
                month = "Июль";
                break;
            case 8:
                month = "Август";
                break;
            case 9:
                month = "Сентябрь";
                break;
            case 10:
                month = "Октябрь";
                break;
            case 11:
                month = "Ноябрь";
                break;
            case 12:
                month = "Декабрь";
                break;
            default:
                month = "Месяца с таким номером не существует!";
                break;
        }
        return month;
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }

    static void matrixFromOneToK(int kForMatrix, String name) {
        double u = Math.sqrt(kForMatrix);
        int row = (int) u;
        int col = (int) u;
        int matrix[][] = new int[row][col];
        int chislo = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = chislo++;
            }
        }

        System.out.println("Ваша матрица от 1 до " +kForMatrix);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                System.out.printf("%s[%d][%d]= %-10d", name, i, j, matrix[i][j]);
                if ((matrix[i][j]) % Math.sqrt(kForMatrix) == 0) {
                    System.out.println();
                }
            }

        }
    }
}
