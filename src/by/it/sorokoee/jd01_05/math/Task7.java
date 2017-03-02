package by.it.sorokoee.jd01_05.math;
import static java.lang.Math.*;
public class Task7 {
    public static double[] getMassiv(int massLength){
        double [] T=new double[massLength];
        for (int i = 0; i <massLength ; i++) {
            T[i]=rint((random()*5+4)*100)/100;
        }
    return T;
    }
    public static double [] sortNewMass(double[] T){
        int count = 0;
        for (int i = 0; i < T.length; i++){
            if (T[i]<0.4*i){
                count++;
            }
        }
        double[] K = new double[count];
        int j= 0;
        for (int i = 0; i < T.length; i++){
            if (T[i]<0.4*i){
                K[j] = T[i];
                j++;
            }
        }

        for (int i = 0; i <K.length-1 ; i++) {
            for (int e=i+1; e <K.length ; e++) {
                if(K[i]>K[e]){
                    double m=K[i];
                    K[i]=K[e];
                    K[e]=m;

                }

            }

        }
        return  K;

    }
    public static void printMassiv(double[] arr, String name) {
        int size=4;
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("%s[%3d ]=%-10.2f",name, i, arr[i]);
            if (((i + 1) % size == 0) || (arr.length - 1 == i)) {
                System.out.println();
            }

        }
        System.out.println();
    }

}
