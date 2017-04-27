package by.it.Zyryanov.my_MatLab;


public class ReportDirector {


    private LongReportBuilder reportBuilder;

    public ReportDirector(LongReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }


    public Report getReport() {

        return  this.reportBuilder.getReport();

    }


    public void makeReport(){

        this.reportBuilder.buildReportHeader();
        this.reportBuilder.buildReportStartTime();
        this.reportBuilder.buildReportFinishTime();
        this.reportBuilder.buildReportCalculations();
        this.reportBuilder.buildReportResultOfCalculations();

    }

}
