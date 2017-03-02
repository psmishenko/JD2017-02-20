package by.it.korzun.jd01_05;

import static java.lang.Math.*;

class Task7 {
    private static void sort(double[] arr){
        boolean swap;
        int last = arr.length - 1;
        do{
            swap = false;
            for (int i = 0; i < last; i++) {
                if(arr[i] < arr[i+1]){
                    double buff = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = buff;
                    swap = true;
                }
            }
            last--;
        }while (swap);

    }

    static void run(){
        System.out.println("Task7");
        double[] massM = new double[29];
        int massKLength = 0;
        double temp = 0;
        for (int i = 0; i < massM.length; i++, temp++) {
            massM[i] = random()*2 + 7;
            massM[i] *= 1000;
            massM[i] = round(massM[i]);
            massM[i] /= 1000;
            if((massM[i] % (int)massM[i]) > (temp/50)){
                massKLength++;
            }
        }


        double[] massK = new double[massKLength];
        temp= 0;
        for (int i = 0, j = 0; i < massM.length; i++, temp++) {
            if((massM[i] % (int)massM[i]) > (temp/50)){
                massK[j] = massM[i];
                j++;
            }
        }

        sort(massK);

        temp = massK.length;
        double colsCount = ceil(temp/6);

        System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
        int cols = 0;
        for (int i = 0; i < massK.length; i++){
            if(colsCount > cols) {
                if(i == 0) {
                    System.out.print(String.format("%-1s[%2s ]%3s", "┃", i, massK[i]));
                }else
                    System.out.print(String.format("%-1s[%2s ]%3s", " ┃", i, massK[i]));
                cols++;
            }else {
                cols = 1;
                System.out.println("\n┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
                System.out.print(String.format("%-1s[%2s ]%3s", "┃", i, massK[i]));
            }


        }
        System.out.println("\n┣━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┫");
    }
}
