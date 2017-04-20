package by.it.smirnov.jd02_09;

import by.it.smirnov.jd02_09.task_a.TaskA;
import by.it.smirnov.jd02_09.task_c.TaskC;

/**
 * Created by aleksey.smirnov on 19.04.2017.
 */
public class Runner {
    public static void main(String[] args) {
        TaskA.createAndShowHTMLfromXML();
        TaskC.createJAXBclassFromXSD();
    }
}
