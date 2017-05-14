package by.it.loktev.project.java.dao;

import by.it.loktev.project.java.beans.Status;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatusDAO extends AbstractDAO implements InterfaceDAO<Status> {

    static private StatusDAO instance;
    static private Map<Integer, Status> map;

    private StatusDAO(){
    }

    static StatusDAO getInstance(){
        if ( instance==null ) {
            synchronized (StatusDAO.class) {
                if (instance == null) {
                    instance = new StatusDAO();
                }
            }
        }
        return instance;
    }


    @Override
    public List<Status> getAll(String whereString) throws SQLException {
        List<Status> list=new ArrayList<Status>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from statuses "+whereString+";";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                Status status=new Status(
                        rs.getInt("id"),
                        rs.getString("name")
                );
                list.add(status);
            }
            return list;
        }

    }

    //@Override
    public Map<Integer, Status> getMap()  {
        Map<Integer,Status> map=new HashMap<>();
        try {
            List<Status> list= getAll("");
            for ( Status status : list ){
                map.put(status.getId(),status);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Status getById(int Id){
        if ( map==null ) {
            synchronized (StatusDAO.class) {
                if (map == null) {
                    map = getMap();
                }
            }
        }
        return map.get(Id);
    }

    @Override
    public Status read(int id) throws SQLException {
        List<Status> list=getAll(" where id="+id+" ");
        if ( list.size()==1 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Status status) throws SQLException {
        int id=status.getId();
        if (id==0) {
            String SQL = "insert into statuses(name) values('" + status.getName() + "');";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                status.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into statuses(id,name) values("+id+",'" + status.getName() + "');";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(Status status) throws SQLException {
        String SQL="update statuses set name='"+status.getName()+"' where id="+status.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(Status status) throws SQLException {
        String SQL="delete from statuses where id="+status.getId()+";";
        return (1==executeUpdate(SQL));
    }
}


