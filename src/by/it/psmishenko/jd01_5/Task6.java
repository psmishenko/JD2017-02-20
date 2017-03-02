package by.it.psmishenko.jd01_5;
import static java.lang.Math.log10;
import static java.lang.Math.abs;

public class Task6 {
    static double[] newMass (){
        double x = 0; int k=0;
        int l = 40;
        double[] arr = new double[l];
        do {
        arr[k] = log10(abs(x-12));
        x+=0.2;
        k++;
        }while (k!=l);
        return arr;
    }
    static void printMass (double[] arr,String name){
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%-4s[%-2d]= %-2.6f\n",name,i,arr[i]);
        }
    }
    static double getAvg (double[] arr){
        double sum = 0;
        for (int i = arr.length-1; i > (arr.length - 10) ; i--) {
            sum+=arr[i];
        }
        return (sum/10);
    }
    static double[] getNewM (double[] arr){
       int c = 0;
        for (int i = 0; i <arr.length ; i++) {
            if(i%3==0) c++;
        }
        double[] mass = new double[c];
        for (int i = 0; i <arr.length ; i++) {
            if(i%3==0) mass[i/3]=arr[i];
        }
        return mass;
    }
}
