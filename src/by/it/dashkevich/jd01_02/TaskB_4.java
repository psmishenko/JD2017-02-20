package by.it.dashkevich.jd01_02;

import java.io.BufferedReader;

import java.io.InputStreamReader;


/**
 * Created by дёня on 05.03.2017.
 */
public class TaskB_4 {
    public static void main(String[] args) {
        BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
        int number;
        String month;
        while(true) {
            try{
              number = Integer.parseInt(rd.readLine());
              break;
            }
            catch (Exception e) {
                System.out.println("Введите число!");
            }
            }

        switch(number){
            case 1: month = "january";
                break;
            case 2: month = "february";
                break;
            case 3: month = "march";
                break;
            case 4: month = "april";
                break;
            case 5: month = "may";
                break;
            case 6: month = "june";
                break;
            case 7: month = "July";
                break;
            case 8: month = "august";
                break;
            case 9: month = "september";
                break;
            case 10: month = "october";
                break;
            case 11: month = "november";
                break;
            case 12: month = "december";
                break;
            default: month = "Invalid month";
                break;

        }
        System.out.println(month);
    }
}
