package by.it.zeynalov.project.java.dao;


public class DAO {

    private static DAO instance;

    public MenuDAO menu;
    public RolesDAO roles;
    public UsersDAO users;

    private DAO() {
    }

    public static DAO getInstance() {
        if (instance == null) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance = new DAO();
                    instance.menu = new MenuDAO();
                    instance.roles = new RolesDAO();
                    instance.users = new UsersDAO();
                }
            }
        }
        return instance;
    }

}
