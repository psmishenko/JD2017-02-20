package by.it.akhmelev.jd01_03;

public class Util {

    static void sort(double[] arr) {
        boolean swap; //признак сортрованности
        int last=arr.length-1;
        do {
            swap = false;
            for (int i = 0; i < last; i++) {
                if (arr[i]>arr[i+1]){
                    double buff=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=buff;
                    swap=true;
                }
            }
            last--;
        } while (swap);
    }

}
