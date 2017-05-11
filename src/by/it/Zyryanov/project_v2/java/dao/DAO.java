package by.it.Zyryanov.project_v2.java.dao;


public class DAO {

    private static DAO dao;

    public Users_DAO user;
    public Roles_DAO role;
    public Books_DAO book;
    public Orders_DAO order;


    public static DAO getDao() {

        if (dao == null) {
            synchronized (DAO.class) {
                if (dao == null) {
                    dao = new DAO();
                    dao.user = new Users_DAO();
                    dao.role = new Roles_DAO();
                    dao.book = new Books_DAO();
                    dao.order = new Orders_DAO();
                }
            }
        }
        return dao;
    }
}
