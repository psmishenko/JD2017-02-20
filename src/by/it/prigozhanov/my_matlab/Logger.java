package by.it.prigozhanov.my_matlab;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;

/**
 * Created by v-omf on 4/15/2017.
 *
 * @author v-omf
 */
public class Logger {
    private static String root = System.getProperty("user.dir");
    private static String path = root + "/src/by/it/prigozhanov/my_matlab/";
    private static String fileName = path + "log.txt";
    private static Logger instance;
    private Logger() {
    }

    public static Logger getLogger() {
        if (instance==null) {
            instance = new Logger();
        }
        return instance;
    }

    public void logError(String error, MatlabException errortype, boolean printAdvancedInfo)  {
        try (PrintWriter pw = new PrintWriter(new FileWriter(fileName, true))){
            Date date = new Date();
            pw.printf("==============\nТип ошибки: %s\nВремя ошибки: %s\n",error, date);
            if (printAdvancedInfo == true) {
                for (int i = 0; i < errortype.getStackTrace().length; i++) {
                    pw.println(errortype.getStackTrace()[i]);
                }
            }
            pw.println("==============\n\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
