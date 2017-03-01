package by.it.radivonik.jd01_01;

/**
 * Created by Radivonik on 01.03.2017.
 */
public class PrintArgs {
    public void showArgs(String args[]) {
        for (String str: args)
            System.out.printf("Аргумент - %s\n",str);
    }
}
