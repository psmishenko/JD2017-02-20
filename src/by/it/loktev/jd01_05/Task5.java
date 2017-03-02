package by.it.loktev.jd01_05;

public class Task5 {

    public static void task5(){
        double r=4.73;
        for (double p=-6; p<25; p+=4){

            double x;
            double pr=p+r;
            if (pr<0.5)
                x=Math.pow(Math.sin(r),5);
            else if ( pr<3 )
                x=0;
            else
                x=Math.sqrt(r+87.34);

            double z=x+Math.exp(r)/2;

            System.out.println(
                    "p="+String.format("%3.0f  ",p)+
                    "p+r="+String.format("%5.2f  ",pr)+
                    "z="+String.format("%8.4f",z)
            );

        }
    }

}
