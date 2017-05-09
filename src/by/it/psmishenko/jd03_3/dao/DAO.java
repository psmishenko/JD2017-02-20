package by.it.psmishenko.jd03_3.dao;

/**
 * Created by GN on 04.05.2017.
 */
public class DAO {
    private static DAO instance;
    public UserDAO user;
    public RoleDAO role;
    public BookDAO book;
    private DAO(){

    }
    public static DAO getInstance(){
        if(instance==null){
            synchronized (DAO.class){
                if(instance==null){
                    instance = new DAO();
                    instance.user = UserDAO.getInstance() ;
                    instance.role = RoleDAO.getInstance();
                    instance.book = BookDAO.getInstance();
                }
            }
        }
        return  instance;
    }
}
