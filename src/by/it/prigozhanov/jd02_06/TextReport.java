package by.it.prigozhanov.jd02_06;

import java.util.Date;

/**
 * Created by v-omf on 4/15/2017.
 *
 * @author v-omf
 */
public class TextReport extends ReportBuilder {
    private boolean showFullReport = true;
    @Override
    public void createHeaderReport(String text) {
        stringBuilder.append("\n=====Отчёт проекта: " + text + "=====" + "\n");
        if (showFullReport) {
            stringBuilder.append("         Вид отчёта: полный\n");
        } else {
            stringBuilder.append("         Вид отчёта: краткий\n");
        }

    }

    @Override
    public void createStartTimeReport(Date time) {
        if (showFullReport) {
            stringBuilder.append("Начало процедуры: ");
            stringBuilder.append(time + "\n");
        } else
            stringBuilder.append("Начало процедуры\n");
    }

    @Override
    public void createOperationReport(String operation, Var res) {
        if (showFullReport) {
            stringBuilder.append("Выполненные операции: ");
            stringBuilder.append(operation + "=" + res + "\n");
        } else {
            stringBuilder.append("Выполненные операции: ");
            stringBuilder.append(operation + "\n");
        }

    }

    @Override
    public void createAssignmentReport(String operation) {
        if (showFullReport) {
        stringBuilder.append("Выполненная операции: ");
        stringBuilder.append(operation + "\n"); }
    }

    @Override
    public void createEndTimeReport(Date time) {
        if (showFullReport) {
            stringBuilder.append("Конец процедуры: ");
            stringBuilder.append(time + "\n");
        } else stringBuilder.append("Конец процедуры\n");
        stringBuilder.append("====================================");
    }

    @Override
    public void fullReport(boolean showFullInfo) {
        this.showFullReport=showFullInfo;
    }


}
