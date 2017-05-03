package by.it.smirnov.jd03_03.Executor;

import by.it.smirnov.jd03_03.Connection.ConnectorCreator;

import java.sql.SQLException;

public abstract class AbstractExecutor {

    protected static String fileName;

    public void run() throws SQLException {
        String[] arrSQL = ParserSQLFile.getArrSQL(fileName);
        for (String sql:arrSQL) {
            ConnectorCreator.getConnection().createStatement().executeUpdate(sql);
        }
    }
}
