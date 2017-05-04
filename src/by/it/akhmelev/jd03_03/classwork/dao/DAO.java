package by.it.akhmelev.jd03_03.classwork.dao;

import by.it.akhmelev.jd03_03.classwork.beans.Ad;
import by.it.akhmelev.jd03_03.classwork.beans.Role;

public class DAO {

    private static DAO instance;

    public UniversalDAO<Role> role;
    public UserDAO user;
    public UniversalDAO<Ad> ad;

    private DAO() {
    }

    public static DAO getInstance(){
        if (instance==null){
            synchronized (DAO.class){
                if(instance==null){
                    instance=new DAO();
                    instance.user=new UserDAO();
                    instance.role=new UniversalDAO<>(new Role(),"roles");
                    instance.ad=new UniversalDAO<>(new Ad(),"ads");
                }
            }
        }
    return instance;
    }
}
