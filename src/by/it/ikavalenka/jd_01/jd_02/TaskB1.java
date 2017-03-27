package by.it.ikavalenka.jd_01.jd_02;

/**
 * Created by USER on 27.03.2017.
 */
public class TaskB1 {


    public boolean include(int k, int[] interval){
        if (k >= Math.min(interval[0],interval[1])&& k<= Math.max(interval[0],interval[1]))
            return true;
        else
            return false;
    }
}
//    public static boolean main(String[] args) {
//        int k = 8;
//        int [] interval = {-3, 12};
//        boolean include = b1.(k,interval);
//
//            if (includeToInterval) {
//                System.out.println("This value" + "included in interval" + Arrays.toString(interval));
//            }else{
//                System.out.println("This value" + "is NOT included in interval" + Arrays.toString(interval));
//            }
//
//    }

