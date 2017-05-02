package by.it.smirnov.jd03_02;

import by.it.smirnov.jd03_02.Executor.AbstractExecutor;

/**
 * Created by aleksey.smirnov on 29.04.2017.
 */
public class C_Init extends AbstractExecutor {
    static {
        fileName = System.getProperty("user.dir") + "/src/by/it/smirnov/jd03_02/sql/init.sql";
    }
}
