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
    public void buildReport(){

        Log log=Log.getInstance();
        Iterator<LogItem> iterator=log.iterator();
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try (
                FileWriter fw = new FileWriter(reportFileName);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            while ( iterator.hasNext() ){
                LogItem li=iterator.next();
                if ( li.kind==LogItemKind.LogItemKind_Start || li.kind==LogItemKind.LogItemKind_End )
                    bw.write(sdf.format(li.time)+" ");
                bw.write(li.text+"\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
