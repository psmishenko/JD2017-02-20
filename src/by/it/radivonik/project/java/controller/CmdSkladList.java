package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Sklad;
import by.it.radivonik.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdSkladList extends AbstractActionList<Sklad> {
    @Override
    protected List<Sklad> getBeans() throws SQLException {
        return DAO.getInstance().getSklad().getAll("");
    }

    @Override
    protected String getParamName() {
        return "sklads";
    }
}
