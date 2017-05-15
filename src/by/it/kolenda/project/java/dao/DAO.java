package by.it.kolenda.project.java.dao;


import by.it.kolenda.project.java.beans.Ad;
import by.it.kolenda.project.java.beans.Role;

public class DAO {
    private static DAO dao;

    public RoleDAO role;
    public UserDAO user;
    public AdDAO ad;

    private DAO(){}
    public static DAO getDAO() {
        if (dao==null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user=new UserDAO ();
                    dao.role=new RoleDAO ();
                    dao.ad = new AdDAO();
                }
            }
        }
        return dao;
    }
}
