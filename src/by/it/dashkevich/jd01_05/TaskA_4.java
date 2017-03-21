package by.it.dashkevich.jd01_05;

/**
 * Created by дёня on 07.03.2017.
 */
public class TaskA_4 {
    public static void main(String[] args) {
        double m =1;
        for(int d = 23; d<=39; d++) {
            for(double t= 2; t<=3; t+=0.1) {

                m *= Math.abs(Math.log10(d-t));
            }
        }
        System.out.println(m);
    }
}
