package by.it.vedom.jd03_01;

import by.it.smirnov.jd03_01.ParserSQLFile;

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
