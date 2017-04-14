package by.it.radivonik.calculator.report;

import by.it.radivonik.calculator.operation.IOperation;

/**
 * Created by Radivonik on 14.04.2017.
 */
public class Report {
    public static String report(IReport rptBuilder) {
        StringBuilder res = new StringBuilder("");
        res.append(rptBuilder.header()).append("\n");
        res.append(rptBuilder.body()).append("\n");
        res.append(rptBuilder.footer()).append("\n");
        return res.toString();
    }
}
