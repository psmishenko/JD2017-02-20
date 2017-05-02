package by.it.korzun.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB)){

            if (connection.isClosed()) {
                System.out.println("closed");
            }
            else {
                System.out.println("open");
            }

//            AddSpecialization.add("Pilot");
//            AddSpecialization.add("Navigator");
//            AddSpecialization.add("Radio-operator");
//            AddSpecialization.add("Stewardess");
//
//            AddStaff.add("Walter", 2);
//            AddStaff.add("Back", 1);
//            AddStaff.add("Baker", 3);
//            AddStaff.add("Alla", 1);
//            AddStaff.add("Masha", 4);
//
//            FormBrigade.form(2,4,1,3,5);
//
//            CreateFlight.create("Minsk", 1);

            ShowFullFlightReport.show(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
