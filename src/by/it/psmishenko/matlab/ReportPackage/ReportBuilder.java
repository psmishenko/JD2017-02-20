package by.it.psmishenko.matlab.ReportPackage;

/**
 * Created by GN on 13.04.2017.
 */
public abstract class ReportBuilder {
    Report report;

    public Report getReport() {
        return report;
    }
    void createNewReport() {
        report = new Report();
    }
    public abstract void buildHeader();
    public abstract void buildRuntime();
    public abstract void buildResults();
    public abstract void buildFooter();
    public abstract void saveReportInTxt();
}
