package by.it.loktev.Calculator;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Iterator;

public class ReportDirectorFull implements IReportDirector {

    String reportFileName;

    @Override
    public void init(String reportFileName) {
        this.reportFileName=reportFileName;
    }

    @Override
    public void buildReport(){

        Log log=Log.getInstance();
        Iterator<LogItem> iterator=log.iterator();
        //DateFormat df=DateFormat.getTimeInstance(DateFormat.)
        SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");

        try (
                FileWriter fw = new FileWriter(reportFileName);
                BufferedWriter bw=new BufferedWriter(fw);
        )
        {
            while ( iterator.hasNext() ){
                LogItem li=iterator.next();
                bw.write(sdf.format(li.time)+" "+li.text+"\n");
            }
            bw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
