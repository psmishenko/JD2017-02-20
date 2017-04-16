package by.it.psmishenko.matlab.ReportPackage;

/**
 * Created by GN on 13.04.2017.
 */
public class ReportDirector {
    public ReportBuilder reportBuilder;

    public void setReportBuilder(ReportBuilder rb) {
        reportBuilder = rb;
    }

    public Report getReport() {
        return reportBuilder.getReport();
    }

   public void constructReport(){
        reportBuilder.createNewReport();
        reportBuilder.buildHeader();
        reportBuilder.buildRuntime();
        reportBuilder.buildResults();
        reportBuilder.buildFooter();
        reportBuilder.saveReportInTxt();
    }
}
