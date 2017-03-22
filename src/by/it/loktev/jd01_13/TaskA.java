package by.it.loktev.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA {

    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        List<Double> values=new ArrayList<>();
        String str="";
        while( !(str=scanner.nextLine()).equals("END") ){
            try {
                Double value = Double.parseDouble(str);
                System.out.println(value);
            }
            catch( NumberFormatException e )
            {
                System.out.printf("Некорректный ввод строки %s\n",str);
            }
        }
    }

}
