package by.it.psmishenko.matlab;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by GN on 13.04.2017.
 */
public  class Timer {
    private long iniTime;
    public static Double Delta;
    public static Date date;

    public Timer() {
        iniTime = System.nanoTime();
        date = new Date();
    }

    public void stopTimer() {
        Delta = (double) (System.nanoTime() - iniTime) / 1000;
    }

    public static Double getDelta() {
        return Delta;
    }
    public static String getStartDate(){
        DateFormat df =  DateFormat.getDateInstance(DateFormat.FULL);
        DateFormat dft = DateFormat.getTimeInstance();
        return  df.format(date)+" "+dft.format(date);
    }
}