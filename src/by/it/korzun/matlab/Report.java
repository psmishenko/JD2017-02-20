package by.it.korzun.matlab;

import java.util.ArrayList;
import java.util.List;

public class Report {
    private String reportName = "";
    private String timeStart;
    private String timeStop;
    private List<String> operations = new ArrayList<>();

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = "Время начала работы: " + timeStart;
    }

    public void setTimeStop(String timeStop) {
        this.timeStop = "Время окончания работы: " + timeStop;
    }

    public void setOperations(List<String> operations) {
        this.operations = operations;
    }

    @Override
    public String toString() {
        System.out.println("/////////////////////////////////////////////////////////////");
        String str = String.format("%-20s\n%-20s\n%-20s\n",reportName, timeStart, timeStop);
        for (int i = 0; i < operations.size(); i++) {
            str = str.concat(operations.get(i) + "\n");
        }
        return str;
    }
}
