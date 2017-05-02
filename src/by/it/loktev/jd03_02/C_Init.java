package by.it.loktev.jd03_02;

import by.it.loktev.jd03_02.beans.Ad;
import by.it.loktev.jd03_02.beans.Role;
import by.it.loktev.jd03_02.beans.User;
import by.it.loktev.jd03_02.crud.AdCRUD;
import by.it.loktev.jd03_02.crud.ConnectorCreator;
import by.it.loktev.jd03_02.crud.RoleCRUD;
import by.it.loktev.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.SQLException;

public class C_Init {

    public static void run() throws SQLException {

        Connection connection= ConnectorCreator.getConnection();

        C_RunSQL.run(
                "CREATE TABLE IF NOT EXISTS `roles` (\n" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `name` varchar(50) DEFAULT NULL,\n" +
                        "  PRIMARY KEY (`id`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n"
        );

        RoleCRUD roleCRUD=new RoleCRUD();
        Role role1=new Role(1,"Администратор");
        roleCRUD.create(role1);
        Role role2=new Role(2,"Пользователь");
        roleCRUD.create(role2);
/*
        C_RunSQL.run(
                "INSERT INTO `roles` (`id`, `name`) VALUES\n" +
                        "\t(1, 'Администратор'),\n" +
                        "\t(2, 'Пользователь');\n"
        );
*/

        C_RunSQL.run(
                "CREATE TABLE IF NOT EXISTS `users` (\n" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `login` varchar(50) DEFAULT NULL,\n" +
                        "  `password` varchar(50) DEFAULT NULL,\n" +
                        "  `email` varchar(50) DEFAULT NULL,\n" +
                        "  `roleid` int(11) DEFAULT '2',\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  KEY `FK_user_roles` (`roleid`),\n" +
                        "  CONSTRAINT `FK_user_roles` FOREIGN KEY (`roleid`) REFERENCES `roles` (`id`)\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;\n"
        );

        UserCRUD userCRUD=new UserCRUD();
        User user1=new User(1,"admin1","pass1","email1@gmail.com",role1.getId());
        userCRUD.create(user1);
        User user2=new User(2,"user2","pass2","email2@gmail.com",role2.getId());
        userCRUD.create(user2);
        User user3=new User(3,"user3","pass3","email3@gmail.com",role2.getId());
        userCRUD.create(user3);
/*
        C_RunSQL.run(
                "INSERT INTO `users` (`id`, `login`, `password`, `email`, `roleid`) VALUES\n" +
                        "\t(1, 'admin1', 'pass1', 'email1@gmail.com', 1),\n" +
                        "\t(11, 'user2', 'pass2', 'email2@gmail.com', 2),\n" +
                        "\t(12, 'user3', 'pass3', 'email3@gmail.com', 2),\n" +
                        "\t(13, 'user4', 'pass4', 'email4@gmail.com', 2),\n" +
                        "\t(14, 'user5', 'pass5', 'email5@gmail.com', 2),\n" +
                        "\t(15, 'user6', 'pass6', 'email6@gmail.com', 2);\n"
        );
*/

        C_RunSQL.run(
                "CREATE TABLE IF NOT EXISTS `ads` (\n" +
                        "  `id` int(11) NOT NULL AUTO_INCREMENT,\n" +
                        "  `floor` int(11) NOT NULL DEFAULT '0',\n" +
                        "  `floors` int(11) NOT NULL DEFAULT '0',\n" +
                        "  `rooms` int(11) NOT NULL DEFAULT '0',\n" +
                        "  `address` varchar(200) NOT NULL DEFAULT '0',\n" +
                        "  `desc` varchar(2000) DEFAULT NULL,\n" +
                        "  `userid` int(11) NOT NULL DEFAULT '0',\n" +
                        "  PRIMARY KEY (`id`),\n" +
                        "  KEY `FK_ad_user` (`userid`),\n" +
                        "  CONSTRAINT `FK_ad_user` FOREIGN KEY (`userid`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE\n" +
                        ") ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;\n"
        );

        AdCRUD adCRUD=new AdCRUD();
        Ad ad1=new Ad(0,1,5,2,"Мулявина 6","ЦА",user2.getId());
        adCRUD.create(ad1);
        Ad ad2=new Ad(0,1,5,2,"Мулявина 7","СервисДеск",user3.getId());
        adCRUD.create(ad2);
        Ad ad3=new Ad(0,1,5,2,"Мулявина 8","ШББ",user2.getId());
        adCRUD.create(ad3);
        /*
        C_RunSQL.run(
                "INSERT INTO `ads` (`id`, `floor`, `floors`, `rooms`, `address`, `desc`, `userid`) VALUES\n" +
                        "\t(4, 1, 5, 2, 'Мулявина 6', 'ЦА', 1),\n" +
                        "\t(5, 3, 5, 2, 'Мулявина 8', 'не ЦА', 1),\n" +
                        "\t(6, 5, 5, 2, 'Мулявина 10', 'не ЦА', 1);\n"
        );
*/

    }
}

