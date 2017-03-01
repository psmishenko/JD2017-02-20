package by.it.loktev.jd01_05;

public class Task4 {

    public static void task4(){

        System.out.println("-----------------------");
        System.out.println("Контрольное задание №4");
        System.out.println("-----------------------");

        for (double t=2; t<=3; t+=0.1){
            double u=1;
            for (double a=12; a<=43; a++){
                u*=Math.pow(t,a-3);
            }
            System.out.println("t="+String.format("%3.1f",t)+" u="+u);
        }
    }

}


