package by.it.sorokoee.project.java.dao;

import by.it.sorokoee.project.java.beans.Good;
import by.it.sorokoee.project.java.connection.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GoodDAO extends AbDAO implements IDAO<Good> {
    @Override
    public boolean create(Good good) {
        String sql = String.format(
                "insert INTO good(modelCar,yearOfIssue,spare,typeEngine,capacityEngine,fk_users)" +
                        "\n values('%s', '%d', '%s', '%s', '%d', '%d');",
                good.getModelCar(),
                good.getYearOfIssue(),
                good.getSpare(),
                good.getTypeEngine(),
                good.getCapacityEngine(),
                good.getFk_users()

        );
        good.setId(executeUpdate(sql));
        return (good.getId() > 0);
    }

    @Override
    public Good read(int id) {
        List<Good> roles = getAll("WHERE id=" + id + " LIMIT 0,1");
        if (roles.size() > 0) {
            return roles.get(0);
        } else
            return null;
    }

    @Override
    public boolean update(Good good)
    {
        String sql = String.format(
                "UPDATE `good` SET " +
                        "`modelCar`='%s'" +
                        ",`yearOfIssue`=%d" +
                        ",`spare`='%s'" +
                        ",`typeEngine`='%s'" +
                        ",`capacityEngine`=%d" +
                        ",`fk_users`=%d " +
                        " WHERE `good`.`id` = %d",
                good.getModelCar(),
                good.getYearOfIssue(),
                good.getSpare(),
                good.getTypeEngine(),
                good.getCapacityEngine(),
                good.getFk_users(),
                good.getId()

        );

        return (0 < executeUpdate(sql));
    }

    @Override
    public boolean delete(Good good) {
        String sql = String.format(
                "DELETE FROM `good` WHERE `good`.`id`=%d;", good.getId()
        );
        return (0 < executeUpdate(sql));
    }

    @Override
    public List<Good> getAll(String WHERE) {
        List<Good> goods = new ArrayList<>();
        String sql = "SELECT * FROM goods " + WHERE + " ;";
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()
        ) {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Good good = new Good();
                good.setId(rs.getInt("id"));
                good.setModelCar(rs.getString("modelCar"));
                good.setYearOfIssue(rs.getInt("yearOfIssue"));
                good.setSpare(rs.getString("spare"));
                good.setTypeEngine(rs.getString("typeEngine"));
                good.setCapacityEngine(rs.getInt("capacityEngine"));
                good.setFk_users(rs.getInt("fk_users"));
                goods.add(good);
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
        return goods;
    }
}
