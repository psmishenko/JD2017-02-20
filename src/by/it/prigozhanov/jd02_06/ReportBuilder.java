package by.it.prigozhanov.jd02_06;

import java.util.Date;

/**
 * Created by v-omf on 4/15/2017.
 *
 * @author v-omf
 */
public abstract class ReportBuilder {

    StringBuilder stringBuilder = new StringBuilder();
    public abstract void createHeaderReport(String text);
    public abstract void createStartTimeReport(Date time);
    public abstract void createOperationReport(String operation, Var res);
    public abstract void createAssignmentReport(String operation);
    public abstract void createEndTimeReport(Date time);
    public abstract void fullReport(boolean showFullInfo);
    public String getInfo() {
        return stringBuilder.toString();
    }

}
