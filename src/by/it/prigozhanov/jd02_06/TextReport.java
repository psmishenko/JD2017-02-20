package by.it.prigozhanov.jd02_06;

import java.util.Date;

/**
 * Created by v-omf on 4/15/2017.
 *
 * @author v-omf
 */
public class TextReport extends ReportBuilder {
    private boolean showFullReport = false;
    @Override
    public void createHeaderReport(String text) {
        stringBuilder.append(text + "\n");
    }

    @Override
    public void createStartTimeReport(Date time) {
        stringBuilder.append("Начало процедуры: ");
        stringBuilder.append(time + "\n");
    }

    @Override
    public void createOperationReport(String operation) {
        stringBuilder.append("Выполненные операции: ");
        stringBuilder.append(operation);
    }

    @Override
    public void createEndTimeReport(Date time) {
        stringBuilder.append("Конец процедуры: ");
        stringBuilder.append(time + "\n");
    }

    @Override
    public void fullReport(boolean showFullInfo) {
        this.showFullReport=true;
    }


}
