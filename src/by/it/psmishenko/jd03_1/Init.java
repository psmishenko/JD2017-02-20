package by.it.psmishenko.jd03_1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 03.05.2017.
 */
public class Init {

    static void recoveryDB(){
        String sql1 =
                "CREATE TABLE IF NOT EXISTS `psmishenko`.`roles` (\n" +
                        "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `Role` VARCHAR(100) NOT NULL,\n" +
                        "  PRIMARY KEY (`ID`))\n" +
                        "ENGINE = InnoDB\n" +
                        "DEFAULT CHARACTER SET = utf8;" ;
        String sql2 = "CREATE TABLE IF NOT EXISTS `psmishenko`.`users` (\n" +
                        "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `Login` VARCHAR(100) NOT NULL,\n" +
                        "  `Password` VARCHAR(100) NOT NULL,\n" +
                        "  `Email` VARCHAR(100) NOT NULL,\n" +
                        "  `FK_roles` INT(11) NOT NULL,\n" +
                        "  PRIMARY KEY (`ID`),\n" +
                        "  INDEX `fk_users_roles_idx` (`FK_roles` ASC),\n" +
                        "  CONSTRAINT `fk_users_roles`\n" +
                        "    FOREIGN KEY (`FK_roles`)\n" +
                        "    REFERENCES `psmishenko`.`roles` (`ID`)\n" +
                        "    ON DELETE RESTRICT\n" +
                        "    ON UPDATE RESTRICT)\n" +
                        "ENGINE = InnoDB\n" +
                        "DEFAULT CHARACTER SET = utf8;\n" ;
        String sql3 = "CREATE TABLE IF NOT EXISTS `psmishenko`.`books` (\n" +
                        "  `ID` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `Author` VARCHAR(100) NOT NULL,\n" +
                        "  `Title` VARCHAR(100) NOT NULL,\n" +
                        "  `Year` INT(100) NOT NULL,\n" +
                        "  `ISBN` VARCHAR(100)  NOT NULL,\n" +
                        "  `LID` INT(100) NOT NULL,\n" +
                        "  `FK_users` INT(11) NOT NULL,\n" +
                        "  PRIMARY KEY (`ID`),\n" +
                        "  INDEX `fk_books_users1_idx` (`FK_users` ASC),\n" +
                        "  CONSTRAINT `fk_books_users1`\n" +
                        "    FOREIGN KEY (`FK_users`)\n" +
                        "    REFERENCES `psmishenko`.`users` (`ID`)\n" +
                        "    ON DELETE CASCADE\n" +
                        "    ON UPDATE CASCADE)\n" +
                        "ENGINE = InnoDB\n" +
                        "DEFAULT CHARACTER SET = utf8;\n";
        try {
            Connection connection  = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
