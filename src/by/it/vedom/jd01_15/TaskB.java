package by.it.vedom.jd01_15;

import java.io.FileWriter;
import java.io.IOException;

public class TaskB {

    public void runTaskB() throws IOException {




        String root = System.getProperty("user.dir");
        String path = root + "/src/by/it/vedom/jd01_15/";
        String fileName = path + "TaskB.txt";
        FileWriter fileWriter = new FileWriter(fileName);


    }
}
