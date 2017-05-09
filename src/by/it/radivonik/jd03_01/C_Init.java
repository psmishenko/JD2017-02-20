package by.it.radivonik.jd03_01;

import by.it.radivonik.jd03_01.connection.ConnectionCreator;

import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Radivonik on 07.05.2017.
 */
public class C_Init {
    public void run() throws SQLException {
        Statement statement = ConnectionCreator.getConnection().createStatement();
        statement.executeUpdate(
            "CREATE TABLE `role` (" +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`name` varchar(100) NOT NULL, " +
            "PRIMARY KEY (`id`) " +
            ") ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8");
        statement.executeUpdate(
            "INSERT INTO `role` VALUES (1,'admin'),(2,'buh'),(3,'sklad')");

        statement.executeUpdate(
            "CREATE TABLE `user` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`login` varchar(100) NOT NULL, " +
            "`password` varchar(100) NOT NULL, " +
            "`email` varchar(100) DEFAULT NULL, " +
            "`id_role` int(11) NOT NULL, " +
            "PRIMARY KEY (`id`), " +
            "KEY `fk_user_role_idx` (`id_role`), " +
            "CONSTRAINT `fk_user_role` FOREIGN KEY (`id_role`) REFERENCES `role` (`id`) " +
            ") ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8");
        statement.executeUpdate(
            "INSERT INTO `user` VALUES (1,'radivonik','admin','olsy@tut.by',1)");

        statement.executeUpdate(
            "CREATE TABLE `tovar` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`name` varchar(100) NOT NULL, " +
            "`edizm` varchar(20) DEFAULT NULL, " +
            "PRIMARY KEY (`id`) " +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

        statement.executeUpdate(
            "CREATE TABLE `typenaklad` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`code` varchar(10) NOT NULL, " +
            "`name` varchar(100) NOT NULL, " +
            "PRIMARY KEY (`id`) " +
            ") ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8");
        statement.executeUpdate(
            "INSERT INTO `typenaklad` VALUES " +
            "(1,'TN_IN','Входящая товарная накладная')," +
            "(2,'TTN_IN','Входящая товарно-транспортная накладная')," +
            "(3,'TN_OUT','Исходящая товарная накладная')," +
            "(4,'TTN_OUT','Исходяшая товарно-транспортная накладная')");

        statement.executeUpdate(
            "CREATE TABLE `klient` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`name` varchar(255) NOT NULL, " +
            "`unp` varchar(20) DEFAULT NULL, " +
            "`adres` varchar(255) NOT NULL, " +
            "PRIMARY KEY (`id`) " +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

        statement.executeUpdate(
            "CREATE TABLE `avto` (" +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`numgos` varchar(20) NOT NULL, " +
            "`voditel` varchar(100) NOT NULL, " +
            "PRIMARY KEY (`id`)" +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

        statement.executeUpdate(
            "CREATE TABLE `naklad` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`date` date NOT NULL, " +
            "`num` varchar(20) NOT NULL, " +
            "`seria` varchar(20) NOT NULL, " +
            "`id_user` int(11) NOT NULL, " +
            "`id_type` int(11) NOT NULL, " +
            "`id_klient` int(11) NOT NULL, " +
            "`id_avto` int(11) DEFAULT NULL, " +
            "PRIMARY KEY (`id`), " +
            "KEY `fk_naklad_user_idx` (`id_user`), " +
            "KEY `fk_naklad_type_idx` (`id_type`), " +
            "KEY `fk_naklad_klient_idx` (`id_klient`), " +
            "KEY `fk_naklad_avto_idx` (`id_avto`), " +
            "CONSTRAINT `fk_naklad_avto` FOREIGN KEY (`id_avto`) REFERENCES `avto` (`id`), " +
            "CONSTRAINT `fk_naklad_klient` FOREIGN KEY (`id_klient`) REFERENCES `klient` (`id`), " +
            "CONSTRAINT `fk_naklad_typenaklad` FOREIGN KEY (`id_type`) REFERENCES `typenaklad` (`id`), " +
            "CONSTRAINT `fk_naklad_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) " +
            ")ENGINE=InnoDB DEFAULT CHARSET=utf8");

        statement.executeUpdate(
            "CREATE TABLE `sostavnaklad` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`id_naklad` int(11) NOT NULL, " +
            "`id_tovar` int(11) NOT NULL, " +
            "`npp` int(11) DEFAULT NULL, " +
            "`count` decimal(16,3) NOT NULL, " +
            "`cena` decimal(16,2) NOT NULL, " +
            "`prnds` decimal(5,2) NOT NULL, " +
            "PRIMARY KEY (`id`), " +
            "KEY `fk_sostavnaklad_naklad_idx` (`id_naklad`), " +
            "KEY `fk_sostavnaklad_tovar_idx` (`id_tovar`), " +
            "CONSTRAINT `fk_sostavnaklad_naklad` FOREIGN KEY (`id_naklad`) REFERENCES `naklad` (`id`), " +
            "CONSTRAINT `fk_sostavnaklad_tovar` FOREIGN KEY (`id_tovar`) REFERENCES `tovar` (`id`) " +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

        statement.executeUpdate(
            "CREATE TABLE `sklad` ( " +
            "`id` int(11) NOT NULL AUTO_INCREMENT, " +
            "`id_tovar` int(11) NOT NULL, " +
            "`count` decimal(16,3) NOT NULL, " +
            "`cena` decimal(16,2) NOT NULL, " +
            "`id_user` int(11) NOT NULL, " +
            "PRIMARY KEY (`id`), " +
            "KEY `fk_sklad_tovar_idx` (`id_tovar`), " +
            "KEY `fk_sklad_user_idx` (`id_user`), " +
            "CONSTRAINT `fk_sklad_tovar` FOREIGN KEY (`id_tovar`) REFERENCES `tovar` (`id`), " +
            "CONSTRAINT `fk_sklad_user` FOREIGN KEY (`id_user`) REFERENCES `user` (`id`) " +
            ") ENGINE=InnoDB DEFAULT CHARSET=utf8");

        System.out.println("Таблицы в базе данных созданы");
    }
}
