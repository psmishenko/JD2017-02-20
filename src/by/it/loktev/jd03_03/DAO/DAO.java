package by.it.loktev.jd03_03.DAO;

public class DAO {

    static private DAO instance;

    private RoleDAO role;
    private UserDAO user;
    private AdDAO ad;


    private DAO(){

    }

    static public DAO getInstance(){
        if ( instance==null ) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance = new DAO();
                    instance.user=UserDAO.getInstance();
                    instance.role=RoleDAO.getInstance();
                    instance.ad=AdDAO.getInstance();
                }
            }
        }
        return instance;
    }

    public RoleDAO getRole() {
        return role;
    }

    public UserDAO getUser() {
        return user;
    }

    public AdDAO getAd() {
        return ad;
    }
}
