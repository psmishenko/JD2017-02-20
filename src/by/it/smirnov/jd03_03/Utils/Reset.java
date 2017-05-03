package by.it.smirnov.jd03_03.Utils;

import by.it.smirnov.jd03_03.Executor.AbstractExecutor;

/**
 * Created by aleksey.smirnov on 03.05.2017.
 */
public class Reset extends AbstractExecutor {
    static {
        fileName = System.getProperty("user.dir") + "/src/by/it/smirnov/jd03_03/sql/reset.sql";
    }
}
