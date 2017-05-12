package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.DAO;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 10.05.2017.
 */
public class CmdUserList extends AbstractActionList<User> {
    @Override
    protected List<User> getBeans() throws SQLException {
        DAO dao = DAO.getInstance();
        return dao.getUser().getAll("");
    }

    @Override
    protected String getParamName() {
        return "users";
    }
}
