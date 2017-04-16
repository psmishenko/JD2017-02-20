package by.it.radivonik.calculator.report;

import by.it.radivonik.calculator.log.Log;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Radivonik on 14.04.2017.
 */
public class ReportMini implements IReport {
    @Override
    public String header() {
        return "--- Краткий отчет (без стека ошибок)\n";
    }

    @Override
    public String body() {
        String patternLog = "\\[\\d+\\] \\d{2}\\.\\d{2}\\.\\d{4} \\d{2}\\:\\d{2}\\:\\d{2}.*";
        StringBuilder res = new StringBuilder("");
        try (BufferedReader fileReader = new BufferedReader(new FileReader(Log.getLog().getLogfile()))) {
            String line;
            while ((line = fileReader.readLine()) != null) {
                if (line.matches(patternLog))
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
