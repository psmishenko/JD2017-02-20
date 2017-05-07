package by.it.prigozhanov.jd03_01;

import java.sql.*;

/**
 * Created by v-omf on 4/30/2017!
 */
public class C_Init {

    public static void initialize() {

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
        Statement statement = connection.createStatement()) {
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `prigozhanov`.`cars` (\n" +
                    "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Mark` VARCHAR(100) NOT NULL,\n" +
                    "  `Model` VARCHAR(100) NOT NULL,\n" +
                    "  `HP` INT(11) NOT NULL,\n" +
                    "  `Location` VARCHAR(100) NOT NULL,\n" +
                    "  `Luggage_capacity` INT(11) NOT NULL,\n" +
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
                    "  `FK_Roles` INT(11) NOT NULL DEFAULT 2,\n" +
                    "  `FK_Cars` INT(11) NULL DEFAULT NULL,\n" +
                    "  PRIMARY KEY (`ID`),\n" +
                    "  INDEX `fk_users_roles_idx` (`FK_Roles` ASC),\n" +
                    "  INDEX `fk_users_cars1_idx` (`FK_Cars` ASC),\n" +
                    "  CONSTRAINT `fk_users_roles`\n" +
                    "    FOREIGN KEY (`FK_Roles`)\n" +
                    "    REFERENCES `prigozhanov`.`roles` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT,\n" +
                    "  CONSTRAINT `fk_users_cars1`\n" +
                    "    FOREIGN KEY (`FK_Cars`)\n" +
                    "    REFERENCES `prigozhanov`.`cars` (`ID`)\n" +
                    "    ON DELETE RESTRICT\n" +
                    "    ON UPDATE RESTRICT)\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;");
            System.out.println("Таблица 'users' сгенерирована");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
