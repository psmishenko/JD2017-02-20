package by.it.loktev.jd01_05;

public class Task1 {

    public static void task1() {

        System.out.println("-----------------------");
        System.out.println("Контрольное задание №1");
        System.out.println("-----------------------");

        double x=0.75;

        double p1=Math.sin(Math.PI/8-1);
        p1*=p1;
        double p2=Math.sqrt(3+x*x);
        double p3=Math.asin(x/2);
        double p4=Math.log(3.12-x);
        double y=(p1+p2)/(p3-5.236e-2)+p4;

        System.out.println(y);

        System.out.println(
                (Math.sin(Math.PI/8-1)*Math.sin(Math.PI/8-1)
                        +Math.sqrt(3+x*x))/(Math.asin(x/2)-5.236e-2)
                        +Math.log(3.12-x));

    }

}
