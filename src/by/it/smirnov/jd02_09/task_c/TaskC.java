package by.it.smirnov.jd02_09.task_c;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by aleksey.smirnov on 19.04.2017.
 */
public class TaskC {
    private final static String path = System.getProperty("user.dir") + "/src/by/it/smirnov/jd02_09/task_b/";
    private final static String fileNameBAT= path + "xjc.bat";

    public static void createJAXBclassFromXSD() {
        try {
            Desktop.getDesktop().open(new File(fileNameBAT));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
