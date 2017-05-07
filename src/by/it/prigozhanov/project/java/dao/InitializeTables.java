package by.it.prigozhanov.project.java.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by v-omf on 4/30/2017!
 */
public class InitializeTables {

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS `prigozhanov`.`orders`,`users`,`cars`,`roles` ;");


            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `prigozhanov`.`cars` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Mark` VARCHAR(100) NOT NULL,\n" +
                    "  `Model` VARCHAR(100) NOT NULL,\n" +
                    "  `HP` INT(11) NOT NULL,\n" +
                    "  `Location` VARCHAR(100) NOT NULL,\n" +
                    "  `Luggage_capacity` INT(11) NOT NULL,\n" +
                    "  `Price` INT(11) NOT NULL,\n" +
                    "  `Seats` INT(11) NOT NULL,\n" +
                    "  `Fuel_consumption` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                        "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");

            System.out.println("Таблица 'cars' сгенерирована");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `prigozhanov`.`roles` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(100) NOT NULL,\n" +
                    "  PRIMARY KEY (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");

            System.out.println("Таблица 'roles' сгенерирована");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `prigozhanov`.`users` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Passport_data` VARCHAR(100) NOT NULL,\n" +
                    "  `Login` VARCHAR(100) NOT NULL,\n" +
                    "  `Password` VARCHAR(100) NOT NULL,\n" +
                    "  `Email` VARCHAR(100) NOT NULL,\n" +
                    "  `FK_Roles` INT(11) NOT NULL DEFAULT '2',\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`FK_Roles` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`FK_Roles`)\n" +
                    "    REFERENCES `prigozhanov`.`roles` (`ID`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            System.out.println("Таблица 'users' сгенерирована");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `prigozhanov`.`orders` (\n" +
                    "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                    "  `Passport_data` VARCHAR(45) NOT NULL,\n" +
                    "  `Card_number` VARCHAR(45) NOT NULL,\n" +
                    "  `Order_duration` INT(11) NOT NULL,\n" +
                    "  `Telephone` VARCHAR(45) NOT NULL,\n" +
                    "  `FK_Users` INT(11) NULL,\n" +
                    "  `FK_Cars` INT(11) NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_Orders_users1_idx` (`FK_Users` ASC),\n" +
                    "  INDEX `fk_Orders_cars1_idx` (`FK_Cars` ASC),\n" +
                    "  CONSTRAINT `fk_Orders_users1`\n" +
                    "    FOREIGN KEY (`FK_Users`)\n" +
                    "    REFERENCES `prigozhanov`.`users` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_Orders_cars1`\n" +
                    "    FOREIGN KEY (`FK_Cars`)\n" +
                    "    REFERENCES `prigozhanov`.`cars` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)");
            System.out.println("Таблица 'orders' сгенерирована");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
