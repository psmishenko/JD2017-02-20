package by.it.radivonik.calculator.report;

import by.it.radivonik.calculator.log.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Radivonik on 14.04.2017.
 */
public class ReportLog implements IReport {
    @Override
    public String header() {
        return "--- Полный отчет\n";
    }

    @Override
    public String body() {
        StringBuilder res = new StringBuilder("");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Log.getLog().getLogfile()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                res.append(line+"\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return res.toString();
    }

    @Override
    public String footer() {
        return "--- Конец отчета\n";
    }
}
