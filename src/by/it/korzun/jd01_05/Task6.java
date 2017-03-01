package by.it.korzun.jd01_05;

import static java.lang.Math.*;

public class Task6 {
    static void run(){
        System.out.println("Task6");
        double[] mass = new double[30];
        int colCount = 8;
        int col = 0;
        int newMassLength = 0;
        String nameOrig = "M";

        for (int i = 0; i < 30; i++) {
            mass[i] = pow(pow(random()*3.67 + 5.33, 2) + 4.5, pow(3, -1));
            if(mass[i] > 3.5){
                newMassLength++;
            }
            if(colCount > col) {
                System.out.printf("%-1s[%2s ] %-8.3f ", nameOrig, i, mass[i]);
                col++;
            }
            else {
                System.out.printf("\n%-1s[%2s ] %-8.3f ", nameOrig, i, mass[i]);
                col = 1;
            }
        }

        double srArifm;
        double sum = 0;
        double []newMass = new double[newMassLength];
        int k = 0;
        for (int i = 0; i < mass.length; i++) {
            if(mass[i] > 3.5){
                newMass[k] = mass[i];
                k++;
            }
        }
        for (int i = 0; i < newMass.length; i++) {
            sum += newMass[i];
        }
        srArifm = sum/newMass.length;

        System.out.println("\nСреднее арифмитическое: " + srArifm);


    }
}
