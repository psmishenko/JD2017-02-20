package by.it.ikavalenka.jd_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by USER on 22.03.2017.
 */
public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Double> values = new ArrayList<>();
        String str;
        while (!(str = scanner.nextLine()).equals("END")) {
            try {
                Double value = Double.parseDouble(str);
                if (value<0) throw new ArithmeticException("Negative values of roots");
                    values.add(Math.sqrt(value));
//                System.out.println(values);
                    Double sum = 0.0;
                for (Double val :values) {
                    sum = sum + val;
                }
                System.out.printf("Sum of all roots = %f\n",sum);

            }
            catch (NumberFormatException e){
                System.out.printf("Incorrect input in console %s\n",str);
            }
            catch (ArithmeticException e){
                System.out.printf("Arithmetic error %s\n", e.getMessage());
            }

                }
            }
        }

