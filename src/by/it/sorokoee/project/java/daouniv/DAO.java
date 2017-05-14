package by.it.sorokoee.project.java.daouniv;


import by.it.sorokoee.project.java.beans.Good;
import by.it.sorokoee.project.java.beans.Role;

public class DAO {
    private static DAO instance;

    public UniversalDAO<Role> role;
    public UserDAO user;
    public UniversalDAO<Good> good;

    private DAO() {
    }

    public static DAO getInstance(){
        if (instance==null){
            synchronized (DAO.class){
                if(instance==null){
                    instance=new DAO();
                    instance.user=new UserDAO();
                    instance.role=new UniversalDAO<>(new Role(),"roles");
                    instance.good=new UniversalDAO<>(new Good(),"goods");
                }
            }
        }
        return instance;
    }
}
