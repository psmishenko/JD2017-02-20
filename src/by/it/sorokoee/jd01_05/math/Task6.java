package by.it.sorokoee.jd01_05.math;

import static java.lang.Math.*;

public class Task6 {
    public static double[] getMass(int massLength) {
        double[] mass = new double[massLength];
        for (double x = 0.0, j = 0; x < 7.0; x += 0.2, j+=1) {
            mass[(int) j] = x + sin(x);
            if (j == massLength - 1) break;
        }
        return mass;
    }
    public static void printMass(double[] mass, String name){
        for (int i = 0; i <mass.length ; i++) {
            System.out.println(String.format("%s[%1d]=%-10.2f",name, i, mass[i]));

        }
    }
    public static void getPrintSumma(double[] mass,String name){
        double sum = 0;

        for (int i= 0; i< mass.length ; i++){
            if (mass[i]>3) {
                sum += mass[i];
            }
        }
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println(String.format("%s%s%s=%-10.5f","Массив: ",name," Сумма элементов массива больше 3 ", sum));
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
    public static double[] getNewMass(double[] mass){
        int count = 0;
        for (int i = 0; i < mass.length; i++){
            if (mass[i]>3){
                count++;
            }
        }
        double[] newMass = new double[count];
        int j= 0;
        for (int i = 0; i < mass.length; i++){
            if (mass[i]>3){
                newMass[j] = mass[i];
                j++;
            }
        }

        return newMass;
    }

}
