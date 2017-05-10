package by.it.zeynalov.jd03_03_DAO.HomeWork.dao;

import by.it.zeynalov.jd03_03_DAO.HomeWork.beans.Menu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MenuDAO extends AbstractDAO implements InterfaceDAO<Menu> {
    public boolean create(Menu menu) throws SQLException {
        String sql = String.format(
                "INSERT INTO `menu`(`Title`, `Price`, `Recept`) " + "VALUES ('%s');",
                menu.getTitle(),
                menu.getPrice(),
                menu.getRecept()
        );
        int id = executeCreate(sql);
        if (id > 0) {
            menu.setId(id);
            return true;
        }
        return false;
    }

    public Menu read(int id) throws SQLException {
        String whereString = String.format(
                " WHERE ID=%d", id
        );
        List<Menu> listMenu = getAll(whereString);
        if (listMenu.size() == 1) {
            return listMenu.get(0);
        }
        return null;
    }

    public boolean update(Menu menu) throws SQLException {
        String sql = String.format(
                "UPDATE `menu` SET " +
                        "`Title`='%s'," +
                        "`Price`='%d'," +
                        "`Recept`='%s'," +
                        "WHERE ID=%d",
                menu.getTitle(),
                menu.getPrice(),
                menu.getRecept(),
                menu.getId()
        );
        return executeUpdate(sql);
    }

    public boolean delete(Menu menu) throws SQLException {
        String sql = String.format(
                "DELETE FROM `menu` WHERE ID=%d",
                menu.getId()
        );
        return executeUpdate(sql);
    }

    @Override
    public List<Menu> getAll(String whereString) throws SQLException {
        List<Menu> result = new ArrayList<>();
        try (Connection connection = ConnectorCreator.getConnection();
             Statement statement = connection.createStatement()) {
            String sql = String.format(
                    "SELECT `ID`, `Title`, `Price`, `Recept` FROM `menu` %s;",
                    whereString
            );
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Menu menu = new Menu(
                        rs.getInt("ID"),
                        rs.getString("Title"),
                        rs.getInt("Price"),
                        rs.getString("Recept")
                );
                result.add(menu);
            }
        }
        return result;
    }
}
