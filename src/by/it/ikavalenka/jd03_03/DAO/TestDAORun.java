package by.it.ikavalenka.jd03_03.DAO;

import java.sql.SQLException;
import java.util.List;

import by.it.ikavalenka.jd03_03.beans.administrator;
import by.it.ikavalenka.jd03_03.beans.client;
import by.it.ikavalenka.jd03_03.beans.blacklist;

/**
 * Created by USER on 14.05.2017.
 */
public class TestDAORun {
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        System.out.println("All");
        List<administrator> administrators = dao.administratorDAO.getAll("");
        System.out.println(administrators);
        List<client> clients = dao.clientDAO.getAll("");
        System.out.println(clients);
        List<blacklist> blacklists = dao.blackListDAO.getAll("");
        System.out.println(blacklists);
        System.out.println("End");
        administrator administrator = new administrator(1,45,23,"CatalogUP",32,12);
        dao.administratorDAO.create(administrator);
        System.out.println(dao.administratorDAO.read(administrator.getAdm_id()));
        dao.administratorDAO.update(new administrator(administrator.getAdm_id(),2,32,"TestCatalog",123,123));
        System.out.println(dao.administratorDAO.read(administrator.getAdm_id()));
        dao.administratorDAO.delete(administrator);
        administrators = dao.administratorDAO.getAll("");
        System.out.println(administrators);
        System.out.println("End");
    }
}
