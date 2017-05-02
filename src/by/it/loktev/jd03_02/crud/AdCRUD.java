package by.it.loktev.jd03_02.crud;

import by.it.loktev.jd03_02.beans.Ad;
import by.it.loktev.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AdCRUD {

    public int create(Ad ad) throws SQLException {
        int id=ad.getId();
        try (
                Connection connection=ConnectorCreator.getConnection();
                Statement statement=connection.createStatement();
        ) {
            if (id==0) {
                String SQL = "insert into ads(floor,floors,rooms,address,`desc`,userid) values(" + ad.getFloor() + "," + ad.getFloors() + "," + ad.getRooms() + ",'" + ad.getAddress() + "','" + ad.getDesc() + "'," + ad.getUserId() + ");";
                statement.executeUpdate(SQL, Statement.RETURN_GENERATED_KEYS);
                ResultSet keys = statement.getGeneratedKeys();
                keys.next();
                id = keys.getInt(1);
                ad.setId(id);
            }
            else{
                String SQL = "insert into ads(id,floor,floors,rooms,address,`desc`,userid) values("+id+"," + ad.getFloor() + "," + ad.getFloors() + "," + ad.getRooms() + ",'" + ad.getAddress() + "','" + ad.getDesc() + "'," + ad.getUserId() + ");";
                statement.executeUpdate(SQL);
            }

        }
        return id;

    }

}


