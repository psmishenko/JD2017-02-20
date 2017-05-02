package by.it.zeynalov.jd02_06.TaskB;

import java.time.LocalDateTime;

public class FullReportBuilder extends ReportBuilder {
    @Override
    public String getTitle() {
        String str = "";
        str += "===================================\n";
        str += "           FULL REPORT             \n";
        str += "===================================\n";
        return str;
    }

    @Override
    public String getTime() {
        return "Start Time: " + History.getInstance().getStartTime().toString() + "\n" + "End Time: " + History.getInstance().getEndTime().toString() + "\n";
    }

    @Override
    public String getOperations() {
        String str = "";
        str += "==================\n";
        str += "OPERATIONS INFO\n";
        str += "==================\n";
        for (int i = 0; i < History.getInstance().getOperations().size(); i++) {
            str += "> Operation #" + (i + 1) + " : " + History.getInstance().getOperations().get(i) + "\n";
        }
        str += "\n\n";
        return str;
    }

    @Override
    public String generateReport() {
        return getTitle() + getTime() + getOperations();
    }
}

