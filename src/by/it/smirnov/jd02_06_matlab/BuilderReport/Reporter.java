package by.it.smirnov.jd02_06_matlab.BuilderReport;

/**
 * Класс формирования отчета
 */
public class Reporter {
    private AbstractBuilderReport builderReport;
    public void setBuilderReport (AbstractBuilderReport br) {
        builderReport = br;
    }
    public Report getReport() {
        return builderReport.getReport();
    }
    /**
     * Формирование отчета
     */
    public void makeReport() {
        builderReport.createNewReport();
        builderReport.makeHeader();
        builderReport.makeBody();
        builderReport.makeFooter();
    }
}
