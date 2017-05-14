package by.it.loktev.project.java.dao;

public class DAO {

    static private DAO instance;

    private RoleDAO role;
    private UserDAO user;
    private TaskDAO task;
    private StatusDAO status;


    private DAO(){

    }

    static public DAO getInstance(){
        if ( instance==null ) {
            synchronized (DAO.class) {
                if (instance == null) {
                    instance = new DAO();
                    instance.user= UserDAO.getInstance();
                    instance.role=RoleDAO.getInstance();
                    instance.task= TaskDAO.getInstance();
                    instance.status= StatusDAO.getInstance();
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

    public TaskDAO getTask() {
        return task;
    }

    public StatusDAO getStatus() {
        return status;
    }

}
