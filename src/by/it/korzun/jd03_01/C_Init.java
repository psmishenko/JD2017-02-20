package by.it.korzun.jd03_01;

import java.sql.*;

public class C_Init {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)){

            Statement statement = connection.createStatement();

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Flights"+
                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                    "Destination VARCHAR(20) NOT NULL, "+
                    "Brigades_ID Int(11) NOT NULL, "+
                    "PRIMARY KEY (ID) )");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Brigades"+
                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                    "FirstPilotID Int(11) NOT NULL, "+
                    "SecondPilotID Int(11) NOT NULL, "+
                    "NavigatorID Int(11) NOT NULL, "+
                    "Radio_operatorID Int(11) NOT NULL, "+
                    "StewardessID Int(11) NOT NULL, "+
                    "PRIMARY KEY (ID) )");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Staff"+
                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                    "Name VARCHAR(20) NOT NULL, "+
                    "FK_Specialization Int(11) NOT NULL, "+
                    "PRIMARY KEY (ID) )");

            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Specializations"+
                    "(ID INT(11) NOT NULL AUTO_INCREMENT, "+
                    "Specialization VARCHAR(20) NOT NULL, "+
                    "PRIMARY KEY (ID) )");

            AddSpecialization.add("Pilot");
            AddSpecialization.add("Navigator");
            AddSpecialization.add("Radio_operator");
            AddSpecialization.add("Stewardess");

            AddStaff.add("Mikhal Potapich", 4);
            AddStaff.add("Pasha", 1);
            AddStaff.add("Max", 1);
            AddStaff.add("Nastya", 2);
            AddStaff.add("Vasya", 3);
            AddStaff.add("Masha", 4);

            AddStaff.add("Walter", 2);
            AddStaff.add("Back", 1);
            AddStaff.add("Baker", 3);
            AddStaff.add("Alla", 1);

            FormBrigade.form(2,3,4,5,6);
            FormBrigade.form(8,10,7,9,1);

            CreateFlight.create("Minsk", 1);
            CreateFlight.create("Amsterdam", 2);

            ShowFullFlightReport.show(1);
            ShowFullFlightReport.show(2);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
