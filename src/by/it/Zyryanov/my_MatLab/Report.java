package by.it.Zyryanov.my_MatLab;

public class Report implements IReportPlan {


    private String reportHeader;
    private String reportStartTime;
    private String reportFinishTime;
    private String reportCalculations;
    private String reportResultOfCalculations;


    public String getReportHeader() {
        return reportHeader;
    }

    public String getReportStartTime() {
        return reportStartTime;
    }

    public String getReportFinishTime() {
        return reportFinishTime;
    }

    public String getReportCalculations() {
        return reportCalculations;
    }

    public String getReportResultOfCalculations() {
        return reportResultOfCalculations;
    }

    @Override
    public void setReportHeader(String header) {

        reportHeader = header;

    }

    @Override
    public void setReportStartTime(String startTime) {

        reportStartTime = startTime;

    }

    @Override
    public void setReportFinishTime(String finishTime) {

        reportFinishTime = finishTime;

    }

    @Override
    public void setReportCalculations(String calculations) {

        reportCalculations = calculations;

    }

    @Override
    public void setReportResultOfCalculations(String resultOfCalculations) {

        reportResultOfCalculations = resultOfCalculations;

    }
}
