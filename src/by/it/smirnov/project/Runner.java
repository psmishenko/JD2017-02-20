package by.it.smirnov.project;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.DAO.UserDAO;
import by.it.smirnov.project.java.DAO.UserRoleDAO;
import by.it.smirnov.project.java.bean.OperType;
import by.it.smirnov.project.java.bean.User;
import by.it.smirnov.project.java.bean.UserRole;
import by.it.smirnov.project.java.bean.Valut;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 11.05.2017.
 */
public class Runner {
    private static final String UserName = "Хмелев А.Г.";
    private static final String UserLogin = "Khmelov";
    private static final String UserPassword = "khmelov1";
    public static void main(String[] args) throws SQLException {
        DAO dao = DAO.getInstance();
        List<User> list = dao.getUser().getAll(String.format(" WHERE Login='%s'",UserLogin));
        if (list.size() == 0) {
            User user=new User();
            user.setName(UserName);
            user.setLogin(UserLogin);
            user.setPassword(UserPassword);
            dao.getUser().create(user);
            UserRole userRole=new UserRole();
            userRole.setIduser(user.getId());
            userRole.setIdrole(1);
            dao.getUserRole().create(userRole);
        }
        if (list.size() == 1) {
            User user = list.get(0);
            user.setLogin(UserLogin);
            user.setPassword(UserPassword);
            dao.getUser().update(user);
        }
        DAO.getInstance().getValut().create(new Valut(0,"USD", "Доллар США"));
        DAO.getInstance().getValut().create(new Valut(0,"BYN", "Белорусский рубль"));

        DAO.getInstance().getOperType().create(new OperType(0,"FX"));
        DAO.getInstance().getOperType().create(new OperType(0,"MM"));
    }
}
