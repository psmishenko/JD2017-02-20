package by.it.zeynalov.jd02_06.TaskB;

import java.time.LocalDateTime;

public class ConsoleRunner {
    public static void main(String[] args) throws MathException {
        History.getInstance().setStartTime(LocalDateTime.now());
        VarF ff = new VarF(20);
        VarF fd = new VarF("555");
        VarF gd = (VarF) ff.sub(fd);
        System.out.println(gd);

        VarFactory vf = new VarFactory();
        VarF f1 = (VarF) vf.createVar(45.0f);
        VarF f2 = (VarF) vf.createVar(45.0f);
        VarF f3 = (VarF) f1.add(f2);

        VarV v1 = (VarV) vf.createVar(new float[]{2.0f, 4.0f});
        VarV v2 = (VarV) vf.createVar(new float[]{3.0f, 5.0f});
        VarF v3 = (VarF) v1.mul(v2);
        System.out.println(f3 + " " + v3);
        History.getInstance().setEndTime(LocalDateTime.now());
        ReportBuilder rb = new FullReportBuilder();
        System.out.println(rb.generateReport());
    }
}
