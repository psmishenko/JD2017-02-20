package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class A_AddData {
    public void run() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        statement.executeUpdate("DELETE FROM tovar WHERE id IN (100, 101, 102)");
        statement.executeUpdate("DELETE FROM sklad WHERE id IN (100, 101, 102)");
        statement.executeUpdate("INSERT INTO tovar (id, name, edizm) VALUES (100, 'Сахар', 'пак.')");
        statement.executeUpdate("INSERT INTO tovar (id, name, edizm) VALUES (101, 'Соль', 'пак.')");
        statement.executeUpdate("INSERT INTO tovar (id, name, edizm) VALUES (102, 'Хлеб', 'бух.')");
        statement.executeUpdate("INSERT INTO sklad (id, count, cena, id_tovar, id_user) VALUES (100, 20, 1.34, 100, 100)");
        statement.executeUpdate("INSERT INTO sklad (id, count, cena, id_tovar, id_user) VALUES (101, 30, 0.85, 101, 100)");
        statement.executeUpdate("INSERT INTO sklad (id, count, cena, id_tovar, id_user) VALUES (102, 40, 0.43, 102, 100)");
    }
}
