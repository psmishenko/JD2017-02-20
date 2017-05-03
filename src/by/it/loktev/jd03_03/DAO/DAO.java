package by.it.loktev.jd03_03.DAO;

public class DAO {

    private DAO instance;

    public RoleDAO role;
    public UserDAO user;
    public AdDAO ad;


    private DAO(){

    }

    DAO getInstance(){
        if ( instance==null ) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance = new DAO();
                    user=new UserDAO();
                    role=new RoleDAO();
                    ad=new AdDAO();
                }
            }
        }
        return instance;
    }

}
