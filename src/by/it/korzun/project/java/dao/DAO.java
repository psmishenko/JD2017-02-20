package by.it.korzun.project.java.dao;

public class DAO {
    private static DAO instance;

    public static SpecDAO spec;
    public static StaffDAO staff;
    public static BrigadeDAO brigade;
    public static FlightDAO flight;

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
                    flight = new FlightDAO();
                }
            }
        }
        return instance;
    }



}
