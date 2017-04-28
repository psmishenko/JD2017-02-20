package by.it.akhmelev.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_04__Init {


    public static void main(String[ ] args) {
        try {
            DriverManager.registerDriver(new FabricMySQLDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //пересоздание базы целиком
            statement.executeUpdate("DROP SCHEMA IF EXISTS `akhmelev` ;");
            statement.executeUpdate("CREATE SCHEMA IF NOT EXISTS `akhmelev` DEFAULT CHARACTER SET utf8 ;");
            //удаление всех таблиц (если работает удаление схемы то это лишнее)
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`ads`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`users`;");
            statement.executeUpdate("DROP TABLE IF EXISTS `akhmelev`.`roles`;");
            //генерация всех таблиц
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`roles` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `Role` VARCHAR(45) NULL,\n" +
                            "  PRIMARY KEY (`ID`))\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`users` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `Login` VARCHAR(45) NULL,\n" +
                            "  `Password` VARCHAR(45) NULL,\n" +
                            "  `Email` VARCHAR(45) NULL,\n" +
                            "  `roles_ID` INT NOT NULL,\n" +
                            "  `userscol` VARCHAR(45) NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_users_roles_idx` (`roles_ID` ASC),\n" +
                            "  CONSTRAINT `fk_users_roles`\n" +
                            "    FOREIGN KEY (`roles_ID`)\n" +
                            "    REFERENCES `akhmelev`.`roles` (`ID`)\n" +
                            "    ON DELETE RESTRICT \n" +
                            "    ON UPDATE RESTRICT )\n" +
                            "ENGINE = InnoDB;"
            );
            statement.executeUpdate(
                    "CREATE TABLE IF NOT EXISTS `akhmelev`.`ads` (\n" +
                            "  `ID` INT NOT NULL AUTO_INCREMENT,\n" +
                            "  `RoomCount` INT NULL,\n" +
                            "  `Flat` INT NULL,\n" +
                            "  `Flats` INT NULL,\n" +
                            "  `Price` DOUBLE NULL,\n" +
                            "  `Area` DOUBLE NULL,\n" +
                            "  `Description` VARCHAR(5000) NULL,\n" +
                            "  `Address` VARCHAR(200) NULL,\n" +
                            "  `FK_users` INT NOT NULL,\n" +
                            "  PRIMARY KEY (`ID`),\n" +
                            "  INDEX `fk_ads_users1_idx` (`FK_users` ASC),\n" +
                            "  CONSTRAINT `fk_ads_users1`\n" +
                            "    FOREIGN KEY (`FK_users`)\n" +
                            "    REFERENCES `akhmelev`.`users` (`ID`)\n" +
                            "    ON DELETE CASCADE\n" +
                            "    ON UPDATE CASCADE)\n" +
                            "ENGINE = InnoDB;"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
