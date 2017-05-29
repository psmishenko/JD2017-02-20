package by.it.ikavalenka.project.java.dao;

import by.it.ikavalenka.jd03_03.DAO.AdministratorDAO;
import by.it.ikavalenka.jd03_03.DAO.BlackListDAO;
import by.it.ikavalenka.jd03_03.DAO.ClientDAO;

/**
 * Created by USER on 14.05.2017.
 */
public class DAO {
    private static DAO instance;
    public by.it.ikavalenka.jd03_03.DAO.AdministratorDAO administratorDAO;
    public ClientDAO clientDAO;
    public BlackListDAO blackListDAO;
    private DAO() {}
    public static DAO getInstance() {
        if (instance == null){
            synchronized (DAO.class){
                if (instance == null){
                    instance = new DAO();
                    instance.administratorDAO=new AdministratorDAO();
                    instance.clientDAO = new ClientDAO();
                    instance.blackListDAO = new BlackListDAO();
                }
            }
        }
        return instance;
    }
}
