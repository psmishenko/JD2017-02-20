package by.it.Zyryanov.my_MatLab;


import java.util.Date;

public class LongReportBuilder implements IReportBuilder{


    private Report report;



    public LongReportBuilder() {

        this.report = new Report();

    }

    @Override
    public void buildReportHeader() {

        report.setReportHeader("==================== ОТЧЁТ(ПОЛНЫЙ) ОБ ОПЕРАЦИЯХ В УЧЕБНОМ ПРОЕКТЕ ====================");

    }

    @Override
    public void buildReportStartTime() {
        Date now = new Date();
        report.setReportStartTime(now.toString());

    }

    @Override
    public void buildReportFinishTime() {
        Date now = new Date();
        report.setReportFinishTime(now.toString());

    }

    @Override
    public void buildReportCalculations() {

        report.setReportCalculations("ВЫЧИСЛЕНИЯ");

    }

    @Override
    public void buildReportResultOfCalculations() {

        report.setReportResultOfCalculations("РЕЗУЛЬТАТ ВЫЧИСЛЕНИЙ");

    }

    @Override
    public Report getReport() {
        return this.report;
    }
}
