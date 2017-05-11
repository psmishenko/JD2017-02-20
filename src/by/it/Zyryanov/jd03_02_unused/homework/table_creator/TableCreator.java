package by.it.Zyryanov.jd03_02_unused.homework.table_creator;




import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static by.it.Zyryanov.jd03_02_unused.homework.crud.ConnectionCreator.getConnection;

public class TableCreator {


    public static void createTable() throws SQLException {

        try {
            Connection connection = getConnection();
            PreparedStatement create = connection.prepareStatement("");
            create.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {

        TableCreator tableCreator = new TableCreator();

        try {
            tableCreator.createTable();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }




    }



