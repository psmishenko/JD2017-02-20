package by.it.sorokoee.project.java.dao;



public class DAO {
    private static DAO dao;


    public UserDAO user;
    public RoleDAO role;
    public GoodDAO good;



    public static DAO getDAO(){
        if (dao==null){
            synchronized (DAO.class){
                if(dao==null){
                    dao=new DAO();
                    dao.user=new UserDAO();
                    dao.role=new RoleDAO();
                    dao.good=new GoodDAO();
                }
            }
        }
        return dao;
    }
}
