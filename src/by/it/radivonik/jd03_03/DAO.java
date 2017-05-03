package by.it.radivonik.jd03_03;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class DAO {
    private static DAO dao;
    public UserDAO user;
    private DAO() {

    }

    public static DAO getInstance() {
        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new UserDAO();

                }
            }
        }
        return dao;
    }
}
