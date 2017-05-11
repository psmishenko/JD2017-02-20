package by.it.Zyryanov.jd03_01;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class dbTableCreator {
    public static void create() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (
                Connection connection =
                        DriverManager.getConnection(CN.URL_DB2, CN.USER_DB, CN.PASSWORD_DB);
        ) {

            Statement statement = connection.createStatement();
            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS `testDB`.`Books` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `BookTitle` VARCHAR(45) NOT NULL,\n" +
                    "  `Description` VARCHAR(1000) NULL DEFAULT NULL,\n" +
                    "  `Author` VARCHAR(45) NOT NULL,\n" +
                    "  `Price` INT(45) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;\n"
            );

            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS `testDB`.`Roles` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Role` VARCHAR(100) NULL DEFAULT '2',\n" +
                    "  PRIMARY KEY (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;"
            );

            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS `testDB`.`Users` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Login` VARCHAR(45) NOT NULL,\n" +
                    "  `Password` VARCHAR(45) NOT NULL,\n" +
                    "  `Email` VARCHAR(45) NOT NULL,\n" +
                    "  `fk_Roles` INT(11) NULL DEFAULT 2,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Roles(sql)_idx` (`fk_Roles` ASC),\n" +
                    "  CONSTRAINT `fk_Roles(sql)`\n" +
                    "    FOREIGN KEY (`fk_Roles`)\n" +
                    "    REFERENCES `testDB`.`Roles` (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "AUTO_INCREMENT = 1\n" +
                    "DEFAULT CHARACTER SET = utf8;"
            );

            statement.executeUpdate("" +
                    "CREATE TABLE IF NOT EXISTS `testDB`.`Orders` (\n" +
                    "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `fk_Book` INT(11) NOT NULL,\n" +
                    "  `fk_Users` INT(11) NOT NULL,\n" +
                    "  PRIMARY KEY (`id`),\n" +
                    "  INDEX `fk_Users` (`fk_Users` ASC),\n" +
                    "  INDEX `fk_Book_idx` (`fk_Book` ASC),\n" +
                    "  CONSTRAINT `fk_Book`\n" +
                    "    FOREIGN KEY (`fk_Book`)\n" +
                    "    REFERENCES `testDB`.`Books` (`id`),\n" +
                    "  CONSTRAINT `fk_Users`\n" +
                    "    FOREIGN KEY (`fk_Users`)\n" +
                    "    REFERENCES `testDB`.`Users` (`id`))\n" +
                    "ENGINE = InnoDB\n" +
                    "DEFAULT CHARACTER SET = utf8;"
            );
            System.out.println("Все таблицы успешно созданы");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
