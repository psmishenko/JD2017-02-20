package by.it.psmishenko.matlab.ReportPackage;

import by.it.psmishenko.matlab.Parser;
import by.it.psmishenko.matlab.Timer;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by GN on 13.04.2017.
 */
public class ShortReport extends ReportBuilder {
    @Override
    public void buildHeader() {
        report.setHeader("Краткий отчёт по работе программы matlab");
    }

    @Override
    public void buildRuntime() {
        report.setRuntime("StartDate: "+Timer.getStartDate()+" ,Time = "+ Timer.getDelta()+" mks");
    }

    @Override
    public void buildResults() {
        report.setResults("Результаты:\n" + Parser.allResults);
    }

    @Override
    public void buildFooter() {
        report.setFooter("Конец отчёта!");
    }

    @Override
    public void saveReportInTxt() {
        String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\matlab\\shortReport.txt";
        try  (BufferedWriter out = new BufferedWriter(new FileWriter(path,true))){
            out.write(report.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
