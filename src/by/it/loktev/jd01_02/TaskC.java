package by.it.loktev.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {

        //System.out.println(Utils.fixedDouble(-0.77777,2,3));
        //System.out.println(Utils.fixedDouble(0.77777,2,3));
        //System.out.println(Utils.fixedDouble(-5.77777,2,3));
        //System.out.println(Utils.fixedDouble(5.77777,2,3));

        Scanner scanner = new Scanner(System.in);
        String line;

        System.out.println("===================");
        System.out.println("Задание JD01_02 C");
        System.out.println("===================");

        System.out.print("Введите размерность матрицы: ");
        line = scanner.nextLine();
        int n = Integer.parseInt(line);

        double [] [] matrix=new double [n] [n];

        for (int row=0; row<n; row++)
            for (int col=0; col<n; col++)
                matrix[row][col]=Math.random()*n*2-n;

        System.out.println("Сгенерирована матрица:");
        Utils.showMatrix(matrix,3);

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 1");
        System.out.println("===================");

        for (int row=0; row<n; row++) {
          int i1=-1, i2=-1;
          for (int col=0; col<n; col++)
          {
              if ( matrix[row][col]>0 ) {
                  if (i1 == -1)
                      i1 = col;
                  else {
                      i2 = col;
                      break;
                  }
              }
          }
          if ( i2==-1 ) {
              System.out.println("Строка "+row+": не найдено двух положительных элементов");
          }
          else
          {
              double sum=0;
              for ( int col=i1+1; col<=i2-1; col++)
                  sum+=matrix[row][col];
              System.out.println("Строка "+row+": сумма элементов между "+i1+"-м и "+i2+"-м: "+sum);
          }

        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 2");
        System.out.println("===================");

        {
            double [] [] matrix2=new double [n] [n];

            for (int col=0; col<n; col++)
                for (int row=0; row<n; row++) {
                  matrix2[col][row]=matrix[row][col];
                }

            System.out.println("После транспонирования получилась матрица:");
            Utils.showMatrix(matrix2,3);
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 3");
        System.out.println("===================");

        {
            double [] [] matrix3=new double [n] [n];

            int x1, y1, x2, y2;
            for (int row=0; row<n; row++) {
                for (int col = 0; col <= Math.min(row, n - row-1-1); col++) {
                    x2=col; y2=row;
                    x1=x2; y1=y2; x2=n-y1-1; y2=x1; matrix3[x2][y2]=matrix[x1][y1];
                    x1=x2; y1=y2; x2=n-y1-1; y2=x1; matrix3[x2][y2]=matrix[x1][y1];
                    x1=x2; y1=y2; x2=n-y1-1; y2=x1; matrix3[x2][y2]=matrix[x1][y1];
                    x1=x2; y1=y2; x2=n-y1-1; y2=x1; matrix3[x2][y2]=matrix[x1][y1];
                }
            }
            // при нечётных n серединка матрицы3 окажется незаполненной
            if (n%2==1) {
                int mid=n/2;
                matrix3[mid][mid]=matrix[mid][mid];
            }

            System.out.println("После поворота получилась матрица:");
            Utils.showMatrix(matrix3,3);
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 4");
        System.out.println("===================");

        {
            double [] [] matrix4=new double [n] [n];

            for (int row=0; row<n; row++) {
                double rowSum=0;
                for (int col = 0; col<n; col++) {
                    rowSum+=matrix[row][col];
                }
                double rowAver=rowSum/n;
                for (int col = 0; col<n; col++) {
                    matrix4[row][col]=matrix[row][col]-rowAver;
                }
            }

            System.out.println("После вычета средних получилась матрица:");
            Utils.showMatrix(matrix4,3);
        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 5");
        System.out.println("===================");

        {
            double maxValue=matrix[0][0];
            for (int col=0; col<n; col++)
                for (int row=0; row<n; row++) {
                  maxValue=Math.max(maxValue,matrix[row][col]);
                }
            System.out.println("Максимальное значение в матрице: "+maxValue);

            int [] leftCols=new int[n]; // номера колонок, которые надо ОСТАВИТЬ
            int leftColsCount=0;
            int [] leftRows=new int[n]; // номера строк, которые надо ОСТАВИТЬ
            int leftRowsCount=0;

            for (int col=0; col<n; col++)
            {
                boolean maxValueExist=false;
                for (int row=0; row<n; row++) {
                    if ( matrix[row][col]==maxValue ) {
                        maxValueExist=true;
                        break;
                    }
                }
                if ( maxValueExist )
                    System.out.println("Удаляем колонку "+col);
                else
                    leftCols[leftColsCount++]=col;
            }
            for (int row=0; row<n; row++)
            {
                boolean maxValueExist=false;
                for (int col=0; col<n; col++) {
                    if ( matrix[row][col]==maxValue ) {
                        maxValueExist=true;
                        break;
                    }
                }
                if ( maxValueExist )
                    System.out.println("Удаляем строку "+row);
                else
                    leftRows[leftRowsCount++]=row;
            }

            double [] [] matrix5=new double [leftRowsCount] [leftColsCount];

            for(int tr=0; tr<leftRowsCount; tr++)
            {
                int sr=leftRows[tr];
                for(int tc=0; tc<leftColsCount; tc++)
                {
                    int sc=leftCols[tc];
                    matrix5[tr][tc]=matrix[sr][sc];
                }
            }

            System.out.println("После удаления столбцов получилась матрица:");
            Utils.showMatrix(matrix5,3);

        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 6");
        System.out.println("===================");

        {
            int minValueRow=0;
            int minValueCol=0;
            double minValue=matrix[minValueRow][minValueCol];
            for (int col=0; col<n; col++)
                for (int row=0; row<n; row++) {
                    if ( matrix[row][col]<minValue )
                    {
                        minValueRow=row;
                        minValueCol=col;
                        minValue=matrix[minValueRow][minValueCol];
                    }
                }
            System.out.println("Минимальное значение в матрице: "+minValue);

            double [] [] matrix6=new double [n] [n];

            int destCol=1;
            int destRow=1;

              for(int tr=0; tr<n; tr++)
              {
                  int sr=(tr==minValueRow)?destRow:(tr==destRow)?minValueRow:tr;
                  for (int tc=0; tc<n; tc++)
                  {
                      int sc=(tc==minValueCol)?destCol:(tc==destCol)?minValueCol:tc;
                      matrix6[tr][tc]=matrix[sr][sc];
                  }

              }


            System.out.println("После перестановки столбцов и строк получилась матрица:");
            Utils.showMatrix(matrix6,3);

        }

        System.out.println("===================");
        System.out.println("Задание JD01_02 C 7");
        System.out.println("===================");
        System.out.println("дробные числа равны 0 с ничтожно малой вероятностью! в конец каждой строки будем выносить ОТРИЦАТЕЛЬНЫЕ элементы");

        {
            double [] [] matrix7=new double [n] [n];

            for (int row=0; row<n; row++)
            {
                int posI=0;
                int negI=n;
                for (int col=0; col<n; col++)
                {
                    double Val=matrix[row][col];
                    if (Val>=0)
                        matrix7[row][posI++]=Val;
                    else
                        matrix7[row][--negI]=Val;
                }
            }

            System.out.println("После перестановки отрицательных в конец строки получилась матрица:");
            Utils.showMatrix(matrix7,3);
        }


    }
}
