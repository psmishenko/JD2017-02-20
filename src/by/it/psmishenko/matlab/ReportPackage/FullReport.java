package by.it.psmishenko.matlab.ReportPackage;

import by.it.psmishenko.matlab.Parser;
import by.it.psmishenko.matlab.Timer;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Created by GN on 13.04.2017.
 */
public class FullReport extends ReportBuilder {

    @Override
    public void buildHeader() {
        report.setHeader("Полный отчёт по работе программы matlab");
    }

    @Override
    public void buildRuntime() {
        report.setRuntime("Дата и время запуска пакета: "+Timer.getStartDate()+
                " .Программа matlab работала :"+ Timer.getDelta()+" микросекунд");
    }

    @Override
    public void buildResults() {
        report.setResults("Введенные операции и результаты их выполнения:\n"+ Parser.allResults);
    }

    @Override
    public void buildFooter() {
        report.setFooter("Конец полного отчёта!");
    }

    @Override
    public void saveReportInTxt() {
        String path = System.getProperty("user.dir")+"\\src\\by\\it\\psmishenko\\matlab\\fullReport.txt";
        try  (BufferedWriter out = new BufferedWriter(new FileWriter(path,true))){
            out.write(report.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
