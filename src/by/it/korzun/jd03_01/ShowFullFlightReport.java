package by.it.korzun.jd03_01;

import java.sql.*;

public class ShowFullFlightReport {
    static void show(int flightID) throws SQLException {
        Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement();
        Statement statementHelper = connection.createStatement();

        String sql = String.format("SELECT * FROM flights WHERE ID = %d", flightID);
        ResultSet flightResultSet = statement.executeQuery(sql);
        flightResultSet.next();

        String report = String.format("Destination: %s\nCrew: \n", flightResultSet.getString("destination"));

        sql = String.format("select * from brigades where ID = %d", flightResultSet.getInt("brigades_ID"));
        ResultSet brigadeResultSet = statement.executeQuery(sql);
        brigadeResultSet.next();

        sql = String.format("SELECT * FROM Staff WHERE ID IN (%d,%d,%d,%d,%d)",
                brigadeResultSet.getInt("FirstPilotID"),
                brigadeResultSet.getInt("SecondPilotID"),
                brigadeResultSet.getInt("NavigatorID"),
                brigadeResultSet.getInt("Radio_operatorID"),
                brigadeResultSet.getInt("StewardessID")
        );

        ResultSet staffResultSet = statementHelper.executeQuery(sql);
        while(staffResultSet.next()){
            sql = String.format("SELECT * FROM Specializations WHERE ID = %d", staffResultSet.getInt("FK_Specialization"));
            ResultSet specResultSet = statement.executeQuery(sql);
            specResultSet.next();
            report = report.concat("\t" + staffResultSet.getString("name") + " - " +
                    specResultSet.getString("Specialization") + "\n");
        }

        System.out.println(report);

        statement.close();
        statementHelper.close();
    }
}
