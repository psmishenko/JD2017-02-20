package by.it.zeynalov.jd03_01.HomeWork;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.*;
import java.util.function.Consumer;

public class SQLHandler {
    private static Connection connection;
    private static Statement stmt;

    public static void connect() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:2016/zeynalov"+
                "?useUnicode=true&characterEncoding=UTF-8", "root", "");
        stmt = connection.createStatement();
    }

    public static void disconnect() {
        try {
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void prepareDB() throws Exception {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/prepare_tables.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
    }

    public static void fullPrepareDB() throws Exception {
        StringBuilder sb = new StringBuilder();
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/cleardb.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
        sb.setLength(0);
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/prepare_tables.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
        sb.setLength(0);
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/prepare_tables_2.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
        sb.setLength(0);
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/prepare_tables_3.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
        sb.setLength(0);
        Files.readAllLines(Paths.get(System.getProperty("user.dir") + "/src/by/it/zeynalov/jd03_01/HomeWork/db/init_data.sql")).stream().forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                sb.append(s + "\n");
            }
        });
        stmt.executeUpdate(sb.toString());
        sb.setLength(0);
    }

    public static void manualDataAdding() throws Exception {
        addUser("Bob", 1);
        addUser("Bob", 2);
        addUser("Bob", 5);
        addUser("Bob", 9);
        addOrder(1, 1);
        addOrder(2, 1);
        addOrder(3, 1);
    }

    public static void main(String[] args) {
        try {
            connect();
            fullPrepareDB();
            showAllUsers();
            //prepareDB();
            //manualDataAdding();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            disconnect();
        }
    }

    public static void addUser(String name, int role) throws SQLException {
        stmt.executeUpdate(String.format("INSERT INTO users (name, role) VALUES ('%s', %d);", name, role));
    }

    public static void addOrder(int userID, int menuId) throws SQLException {
        stmt.executeUpdate(String.format("INSERT INTO orders (userID, menuID) VALUES (%d, %d);", userID, menuId));
    }

    public static void addRole(int id, String title) throws SQLException {
        stmt.executeUpdate(String.format("INSERT INTO roles (ID, Title) VALUES ('%s', '%s');", id, title));
    }

    public static void showAllUsers() throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT users.name, roles.title FROM users INNER JOIN roles ON users.role=roles.id");
        while(rs.next() != false) {
            System.out.println(rs.getString(1) + " " + rs.getString(2));
        }
        rs.close();
    }
}
/*
CREATE TABLE orders (
    id     INTEGER AUTO_INCREMENT,
    userID INTEGER REFERENCES users (id),
    menuID INTEGER REFERENCES menu (id))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE roles (
    ID    INTEGER PRIMARY KEY AUTO_INCREMENT,
    Title VARCHAR (100))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE users (
    id          INTEGER  PRIMARY KEY AUTO_INCREMENT,
    login       VARCHAR (100),
    password    VARCHAR (100),
    email       VARCHAR (100),
    fc_rolles   INTEGER  REFERENCES roles (ID))

ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;
 */