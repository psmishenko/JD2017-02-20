package by.it.korzun.matlab;

public class Waiter {
    private ReportBuilder reportBuilder;

    void setReportBuilder(ReportBuilder rb){
        reportBuilder = rb;
    }

    Report getReport(){
        return reportBuilder.getReport();
    }

    void constructReport(){
        reportBuilder.createNewReport();
        reportBuilder.buildName();
        reportBuilder.buildStartTime();
        reportBuilder.buildStopTime();
        reportBuilder.buildOperations();
    }
}
