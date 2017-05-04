package by.it.korzun.jd03_03.dao;

public class DAO {
    private static DAO instance;

    public static SpecDAO spec;
    public static StaffDAO staff;
    public static BrigadeDAO brigade;

    public DAO() {
    }

    public static DAO getInstance(){
        if(instance == null){
            synchronized (DAO.class){
                if(instance == null){
                    instance = new DAO();
                    spec = new SpecDAO();
                    staff = new StaffDAO();
                    brigade = new BrigadeDAO();
                }
            }
        }
        return instance;
    }



}
