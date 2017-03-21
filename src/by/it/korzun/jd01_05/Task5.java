package by.it.korzun.jd01_05;

import static java.lang.Math.*;

class Task5 {
    static void run(){
        System.out.println("Task 5: ");
        double z;
        double r = 4.73;
        double x;
        for (int p = -6; p < 25; p += 4){
            if (p + r < 0.5){
                x = pow(sin(r), 5);
            } else if ((p + r) >= 0.5 && (p + r) < 3){
                x = 0;
            } else if (p + r > 3){
                x = sqrt(r + 87.34);
            } else{
                continue;
            }
            z = x + pow(E, r)/2;
            System.out.println(String.format("%-5s%-20s", p, z));
        }
    }
}
