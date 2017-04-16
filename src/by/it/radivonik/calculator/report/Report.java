package by.it.radivonik.calculator.report;

import by.it.radivonik.calculator.operation.IOperation;

/**
 * Created by Radivonik on 14.04.2017.
 */
public class Report {
    public static String report(IReport rptBuilder) {
        StringBuilder res = new StringBuilder("");
        res.append(rptBuilder.header());
        res.append(rptBuilder.body());
        res.append(rptBuilder.footer());
        return res.toString();
    }
}
