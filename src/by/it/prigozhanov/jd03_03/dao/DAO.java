package by.it.prigozhanov.jd03_03.dao;

/**
 * Created by v-omf on 5/3/2017!
 */
public class DAO {
    private static DAO instance;

    public UserDAO user;
    public CarDAO car;
    public RoleDAO role;

    private DAO() {
    }

    public static DAO getInstance() {
        if (instance == null) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance=new DAO();
                    instance.car = new CarDAO();
                    instance.user = new UserDAO();
                    instance.role = new RoleDAO();
                }
            }
        }


        return instance;
    }

}
