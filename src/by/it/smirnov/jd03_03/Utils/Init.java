package by.it.smirnov.jd03_03.Utils;

import by.it.smirnov.jd03_03.Executor.AbstractExecutor;

/**
 * Created by aleksey.smirnov on 29.04.2017.
 */
public class Init extends AbstractExecutor {
    static {
        fileName = System.getProperty("user.dir") + "/src/by/it/smirnov/jd03_03/sql/init.sql";
    }
}
