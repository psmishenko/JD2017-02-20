package by.it.loktev.project.java.dao;

import by.it.loktev.project.java.beans.Status;
import by.it.loktev.project.java.beans.Task;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TaskDAO extends AbstractDAO implements InterfaceDAO<Task> {

    static private TaskDAO instance;

    //static SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
    static String MySQLDate(Date value){
        if ( value==null )
            return "null";
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        return "'"+dateFormat.format(value)+"'";
    }

    private TaskDAO(){
    }

    static TaskDAO getInstance(){
        if ( instance==null ) {
            synchronized (TaskDAO.class) {
                if (instance == null) {
                    instance = new TaskDAO();
                }
            }
        }
        return instance;
    }

    @Override
    public List<Task> getAll(String whereString) throws SQLException {
        List<Task> list=new ArrayList<Task>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from tasks "+whereString+";";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                Task task=new Task(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDate("enddate"),
                        rs.getDouble("price"),
                        rs.getInt("statusid")
                );
                list.add(task);
            }
            return list;
        }

    }

    @Override
    public Task read(int id) throws SQLException {
        List<Task> list=getAll(" where id="+id+" ");
        if ( list.size()==1 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Task task) throws SQLException {
        int id=task.getId();
        if (id==0) {
            String SQL = "insert into tasks(name,enddate,price,statusid) values('" + task.getName() + "'," + MySQLDate(task.getEndDate()) + "," + task.getPrice() + "," + task.getStatusId() + ");";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                task.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into tasks(id,name,enddate,price,statusid) values("+id+",'" + task.getName() + "'," + MySQLDate(task.getEndDate()) + "," + task.getPrice() + "," + task.getStatusId() + ");";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(Task task) throws SQLException {
        String SQL="update tasks set name='"+task.getName()+"',enddate="+MySQLDate(task.getEndDate())+",price="+task.getPrice()+",statusid="+task.getStatusId()+" where id="+task.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(Task task) throws SQLException {
        String SQL="delete from tasks where id="+task.getId()+";";
        return (1==executeUpdate(SQL));
    }


}


