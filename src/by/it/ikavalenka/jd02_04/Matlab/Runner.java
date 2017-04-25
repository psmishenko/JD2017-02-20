package by.it.ikavalenka.jd02_04.Matlab;
import java.io.*;
import java.util.*;

public class Runner {

    public static void main (String [] args) throws IOException, ErrorException {

        Date startTime = new Date();
        ReportDirector reportDirector = new ReportDirector();
        ReportBuilder operReportBuilder = new OperationReportBuilder(startTime);
        reportDirector.setReportBuilder(operReportBuilder);
        reportDirector.createReport();

        Map<String,Var> map = UtilsMatlab.putVarsFromFileIntoMap() ;
        //List<String> list = new ArrayList<>(map.keySet());

        System.out.println("Enter values");

        while(true) {

            System.out.println("Values for count");
            String line = InitialLine.enterLine();
            if (line.isEmpty()) break;
            try {
                Parser.pars(line);
            } catch (Exception e) {
                System.out.println("Error message ");
                Logger.getInstance().writeToLog("Rows "+line+": Error, ");
                synchronized (QueueOperationsForReport.getQueueOperationsForReport()){
                    QueueOperationsForReport.addOperation(line);
                    QueueOperationsForReport.getQueueOperationsForReport().notifyAll();

                }

            }
        }
        OperationReportBuilder.setFinish(true);
        synchronized (QueueOperationsForReport.getQueueOperationsForReport()){
            QueueOperationsForReport.getQueueOperationsForReport().notifyAll();

        }


        String src = System.getProperty("user.dir") + "/src/by/it/ikavalenka/jd02_04/Matlab/vars.txt";
        File file = new File(src);
        UtilsMatlab.saveVarsInFile( file);


        System.out.println("Enter print. ");
        System.out.println("Enter sort.");
        System.out.println("Enter END");
        String line = UtilsMatlab.enterLine();

        UtilsMatlab.printVarList(line, MapVariables.getMap());

        File report = reportDirector.getReport();

    }
}
