package by.it.ikavalenka.jd_01.jd_02;

import java.util.Arrays;

/**
 * Created by USER on 27.03.2017.
 */
public class Runner {
    public static void main (String[] args){
        TaskB1 b1 = new TaskB1();
        int kv = 8;
        int [] interval = {-3, 5};
        boolean include = b1.include(kv,interval);

        if (include) {
            System.out.println("This value" + "included in interval" + Arrays.toString(interval));
        }else{
            System.out.println("This value" + "is NOT included in interval" + Arrays.toString(interval));
        }
    }
}
