package by.it.smirnov.jd02_06_matlab.BuilderReport;

/**
 * Абстрактный класс отчета
 */
abstract public class AbstractBuilderReport {
    Report report;

    Report getReport(){
        return report;
    }
    void createNewReport(){
        report = new Report();
    }

    /**
     * Формирование шапки отчета
     */
    public abstract void makeHeader();
    /**
     * Формирование тела отчета
     */
    public abstract void makeBody();
    /**
     * Формирование итога отчета
     */
    public abstract void makeFooter();
}
