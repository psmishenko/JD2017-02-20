package by.it.loktev.Calculator;

import java.sql.Time;

public class LogItem{

    private LogItemKind kind;
    private String text;
    private Time time;

    public LogItem(LogItemKind kind, String text) {
        this.kind = kind;
        this.text = text;
        this.time=new Time(System.currentTimeMillis());
                /*
        DateFormat df=Language.getDateFormat();
        System.out.println(df.format(new Date()));

                 */
    }


}
