package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Naklad;
import by.it.radivonik.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 15.05.2017.
 */
public class CmdNakladList extends AbstractActionList<Naklad> {
    @Override
    protected List<Naklad> getBeans() throws SQLException {
        return DAO.getInstance().getNaklad().getAll("");
    }

    @Override
    protected String getParamName() {
        return "naklads";
    }
}
