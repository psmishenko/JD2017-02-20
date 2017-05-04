package by.it.psmishenko.jd03_2.crud;

import by.it.psmishenko.jd03_2.beans.Book;
import by.it.psmishenko.jd03_2.beans.Role;
import by.it.psmishenko.jd03_2.beans.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by GN on 03.05.2017.
 */
public class Init {

   public static void recoveryDB(){
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
        try (Connection connection = ConnectorCreator.getConnection();
                 Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql1);
            statement.executeUpdate(sql2);
            statement.executeUpdate(sql3);
            System.out.println("Таблицы добавлены");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void enterData() throws SQLException {
        RoleCrud roleCrud = new RoleCrud();
        Role role1 = new Role(1,"Admin");
        Role role2 = new Role(2,"User");
        Role role3 = new Role(3,"Guest");
        roleCrud.create(role1);roleCrud.create(role2);roleCrud.create(role3);
        UserCrud userCrud = new UserCrud();
        User user1 = new User(1,"Admin1","admin1","admin1@mail.ru",role1.getId());
        User user2 = new User(1,"User1","user1","user1@mail.ru",role2.getId());
        User user3 = new User(1,"User2","user2","user2@mail.ru",role2.getId());
        userCrud.create(user1); userCrud.create(user2); userCrud.create(user3);
        BookCrud bookCrud = new BookCrud();
        Book book = new Book(1,"S.King","LOL",1999,"123-3321-111",1234321,user2.getId());
        Book book1 = new Book(1,"S.King","LOLOLOLO",1978,"123-31121-111",1234121,user3.getId());
        bookCrud.create(book);bookCrud.create(book1);

    }
}
