package by.it.ikavalenka.jd_01.jd_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by USER on 05.04.2017.
 */
public class TaskB4 {
    public static boolean isMonth(double s){
        return s % 1 ==0;
    }
    public static void main(String[] args) throws IOException{
      String[] months = {
              "Январь",
              "Февраль",
              "Март",
              "Апрель",
              "Май",
              "Июнь",
              "Июль",
              "Август",
              "Сентябрь",
              "Октябрь",
              "Ноябрь",
              "Декабрь",
      };
        InputStreamReader inputStreamReader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        System.out.println("Enter, month number");
        double input = Double.valueOf(bufferedReader.readLine());
        bufferedReader.close();
        if (isMonth(input)){
            if (input>=0&&input<=12){
                System.out.println("Chosed month" + months[(int)input]);
            }else if (input<0) {
                System.out.println("Incorect month" + months[13]);
            }else {
                System.out.println("Selected month" + months[14]);
            }
            }else {
            System.out.println("Correct month" + months[15]);
        }
    }

}
