package by.it.kolenda.project.java;


//import by.it.kolenda.jd03_03.UniversalDAO;
//import by.it.kolenda.jd03_03.UserDAO;
import by.it.kolenda.project.java.beans.Ad;
import by.it.kolenda.project.java.beans.Role;

public class DAO {
    private static DAO instance;
    public UniversalDAO<Role> role;
    public UserDAO user;
    public UniversalDAO <Ad> ad;

    private DAO(){}
    public static DAO getInstance() {
        if (instance==null) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance.user=new UserDAO ();
                    instance.role=new UniversalDAO<>(new Role(),"roles");
                    instance.ad = new UniversalDAO<>(new Ad(), "ads");
                }
            }
        }
        return instance;
    }
}
