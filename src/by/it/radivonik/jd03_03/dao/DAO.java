package by.it.radivonik.jd03_03.dao;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class DAO {
    private static DAO dao;
    private RoleDAO role;
    private UserDAO user;
    private TovarDAO tovar;
    private KlientDAO klient;
    private AvtoDAO avto;

    private DAO() {

    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.role = new RoleDAO();
                    dao.user = new UserDAO();
                    dao.tovar = new TovarDAO();
                    dao.klient = new KlientDAO();
                    dao.avto = new AvtoDAO();
                }
            }
        }
        return dao;
    }

    public RoleDAO getRole() {
        return role;
    }

    public UserDAO getUser() {
        return user;
    }

    public TovarDAO getTovar() {
        return tovar;
    }

    public KlientDAO getKlient() {
        return klient;
    }

    public AvtoDAO getAvto() {
        return avto;
    }
}
