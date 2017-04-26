package by.it.Zyryanov.my_MatLab;

public interface IReportBuilder {

    void buildReportHeader();
    void buildReportStartTime();
    void buildReportFinishTime();
    void buildReportCalculations();
    void buildReportResultOfCalculations();

    public Report getReport();
}
