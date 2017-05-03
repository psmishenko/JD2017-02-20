package by.it.loktev.jd03_03.DAO;

import by.it.loktev.jd03_03.beans.Ad;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AdDAO extends AbstractDAO implements InterfaceDAO<Ad> {

    @Override
    public List<Ad> getAll(String whereString) throws SQLException {
        List<Ad> list=new ArrayList<Ad>();
        try (
                Connection connection= ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();

        ){
            String SQL="select * from ads;";
            ResultSet rs=statement.executeQuery(SQL);
            while ( rs.next() ) {
                Ad ad=new Ad(
                        rs.getInt("id"),
                        rs.getInt("floor"),
                        rs.getInt("floors"),
                        rs.getInt("rooms"),
                        rs.getString("address"),
                        rs.getString("desc"),
                        rs.getInt("userid")
                );
                list.add(ad);
            }
            return list;
        }

    }

    @Override
    public Ad read(int id) throws SQLException {
        List<Ad> list=getAll(" where id="+id+" ");
        if ( list.size()==1 ){
            return list.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Ad ad) throws SQLException {
        int id=ad.getId();
        if (id==0) {
            String SQL = "insert into ads(floor,floors,rooms,address,`desc`,userid) values(" + ad.getFloor() + "," + ad.getFloors() + "," + ad.getRooms() + ",'" + ad.getAddress() + "','" + ad.getDesc() + "'," + ad.getUserId() + ");";
            id=executeCreate(SQL);
            if ( id>=0 ) {
                ad.setId(id);
                return true;
            }
            return false;
        }
        else {
            String SQL = "insert into ads(id,floor,floors,rooms,address,`desc`,userid) values("+id+"," + ad.getFloor() + "," + ad.getFloors() + "," + ad.getRooms() + ",'" + ad.getAddress() + "','" + ad.getDesc() + "'," + ad.getUserId() + ");";
            return (1==executeUpdate(SQL));
        }
    }

    @Override
    public boolean update(Ad ad) throws SQLException {
        String SQL="update ads set floor="+ad.getFloor()+",floors="+ad.getFloors()+",rooms="+ad.getRooms()+",address='"+ad.getAddress()+"',`desc`='"+ad.getDesc()+"',userid="+ad.getUserId()+" where id="+ad.getId()+";";
        return (1==executeUpdate(SQL));
    }

    @Override
    public boolean delete(Ad ad) throws SQLException {
        String SQL="delete from ads where id="+ad.getId()+";";
        return (1==executeUpdate(SQL));
    }


}


