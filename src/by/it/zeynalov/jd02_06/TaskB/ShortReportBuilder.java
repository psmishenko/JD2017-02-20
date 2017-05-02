package by.it.zeynalov.jd02_06.TaskB;

import java.time.LocalTime;

public class ShortReportBuilder extends ReportBuilder{
    @Override
    public String getTitle() {
        return "Report:\n";
    }

    @Override
    public String getTime() {
        return "Start Time: " + History.getInstance().getStartTime().toLocalTime().toString() + "\n" + "End Time: " + History.getInstance().getEndTime().toLocalTime().toString() + "\n";
    }

    @Override
    public String getOperations() {
        String str = "";
        str += "OPERATIONS: \n";
        for (int i = 0; i < History.getInstance().getOperations().size(); i++) {
            str += "> " + History.getInstance().getOperations().get(i) + "\n";
        }
        str += "\n";
        return str;
    }


    @Override
    public String generateReport() {
        return getTitle() + getTime() + getOperations();
    }
}

