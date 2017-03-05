package by.it.korzun.jd01_02;


import java.util.Scanner;

class TaskC {

    void run(){
        System.out.println("Введите размерность матрицы: ");
        Scanner scanner = new Scanner(System.in);
        String nStr = scanner.next();
        int n = Integer.parseInt(nStr);
        double [][]matrix = new double[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = ((int)(Math.random() * 2*n + 1)) - n;
            }
        }

        Util.printMatrix(matrix, true);

        int sum = 0;
        for (int i = 0; i < n; i++) {
            int leftPosition = Integer.MAX_VALUE;
            int rightPosition = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] > 0 && leftPosition == Integer.MAX_VALUE){
                    leftPosition = j;
                }else if(matrix[i][j] > 0 && rightPosition == Integer.MAX_VALUE){
                    rightPosition = j;
                    if((j - 1) == leftPosition){
                        break;
                    }
                }

                if(leftPosition != Integer.MAX_VALUE && rightPosition != Integer.MAX_VALUE){
                    int k = leftPosition + 1;
                    while (k != rightPosition){
                        sum += matrix[i][k];
                        k++;
                    }
                    break;
                }

            }
        }
        System.out.println("1)Сумма элементов матрицы, расположенных между первым и\n" +
                "\tвторым положительными элементами каждой строки: " + sum);

        System.out.println("\n2)Транспонированная матрица: ");
        double tempValue;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                tempValue = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tempValue;
            }
        }
        Util.printMatrix(matrix, true);


        System.out.println("\n3)Поворот матрицы против часовой стрелки на 90 градусов: ");
        double [][]tempMatrix = new double[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(matrix[i], 0, tempMatrix[i], 0, n);
        }
        int coll = 0;
        for (int i = 0; i < n; i++) {
            int str = 0;
            for (int j = 0; j < n; j++) {
                matrix[i][j] = tempMatrix[str][n - 1 - coll];
                str++;
            }
            coll++;
        }

        Util.printMatrix(matrix, true);


        System.out.println("\n4)Построить матрицу, вычитая из элементов каждой строки матрицы ее\n" +
                "среднее арифметическое:");
        for (int i = 0; i < n; i++) {
            int k = 0;
            int strSum = 0;
            while (k != n){
                strSum += matrix[i][k];
                k++;
            }
            double strSrArifm = (double)strSum/(double)n;
            for (int j = 0; j < n; j++) {
                matrix[i][j] -= strSrArifm;
            }
        }

        Util.printMatrix(matrix, false);
        System.out.println("\n5)Найти максимальный элемент (ы) в матрице и удалить из матрицы все\n" +
                "строки и столбцы, его содержащие: ");
        double max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] > max){
                    max = (int)matrix[i][j];
                }
            }
        }
        //System.out.println("Максимальное значение элемента(ов) = " + max);
        //matrix = Util.deleteByElement(matrix, max);
        //Util.printMatrix(matrix, true);


        System.out.println("\n6)Переместить минимальный элемент в [1,1]: ");
        int minI = Integer.MIN_VALUE;
        int minJ = Integer.MIN_VALUE;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] < min){
                    min = matrix[i][j];
                    minI = i;
                    minJ = j;
                }
            }
        }

        double []tempMassI = new double[n];
        double []tempMassJ = new double[n];
        for (int i = 0; i < n; i++) {
            tempMassI[i] = matrix[minI][i];
        }

        for (int i = 0; i < n; i++) {
            matrix[minI][i] = matrix[1][i];
            matrix[1][i] = tempMassI[i];
        }

        for (int i = 0; i < n; i++) {
            tempMassJ[i] = matrix[i][minJ];
        }

        for (int i = 0; i < n; i++) {
            matrix[i][minJ] = matrix[i][1];
            matrix[i][1] = tempMassJ[i];
        }

        Util.printMatrix(matrix, true);

        System.out.println("7)Преобразвать строки так, чтобы нули были в конце: ");

        for (int i = 0; i < n; i++) {
            Util.bubbleSortAbs(matrix[i]);
        }

        Util.printMatrix(matrix, true);
    }
}
