package by.it.loktev.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class ReportDirectorShort implements IReportDirector {

    String reportFileName;

    @Override
    public void init(String reportFileName) {
        this.reportFileName=reportFileName;
    }

    @Override
    public void buildReport(ReportBuilder rb){

        Log log=Log.getInstance();
        Iterator<LogItem> iterator=log.iterator();
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        rb.start();
        while ( iterator.hasNext() ){
            LogItem li=iterator.next();
            switch ( li.kind ){
                case LogItemKind_Start:
                    rb.buildHeaderLine(sdf.format(li.time)+" "+li.text);
                    break;
                case LogItemKind_End:
                    rb.buildFooterLine(sdf.format(li.time)+" "+li.text);
                    break;
                default:
                    rb.buildTextLine(li.text);
                    break;
            }
        }

        try (
                FileWriter fw = new FileWriter(reportFileName);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            bw.write(rb.getResult());
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
