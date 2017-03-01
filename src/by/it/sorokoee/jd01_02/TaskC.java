package by.it.sorokoee.jd01_02;

import java.util.Scanner;

public class TaskC {
    public  static void getPrintMatrix(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введите размерность матрицы:");
        int n=scanner.nextInt();
        System.out.print("Введите длину интервала:");
        int k=scanner.nextInt();
        int [][] mass=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                mass[i][j]=-k/2+(int)(Math.random()*(k+1));
                System.out.print(mass[i][j]+"\t");

            }
            System.out.println();

        }

    }

    public  static void sumRowMatrix(){
        Scanner scanner=new Scanner(System.in);
        System.out.print("Введите размерность матрицы:");
        int n=scanner.nextInt();
        System.out.print("Введите длину интервала:");
        int k=scanner.nextInt();
        int sum=0;
        int [][] mass=new int[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                mass[i][j]=-k/2+(int)(Math.random()*(k+1));



            }
            System.out.println();

        }

    }

}
