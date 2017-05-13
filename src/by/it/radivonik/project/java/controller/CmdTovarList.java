package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Tovar;
import by.it.radivonik.project.java.dao.DAO;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 12.05.2017.
 */
public class CmdTovarList extends AbstractActionList<Tovar> {
    @Override
    protected List<Tovar> getBeans() throws SQLException {
        return DAO.getInstance().getTovar().getAll("");
    }

    @Override
    protected String getParamName() {
        return "tovars";
    }
}
