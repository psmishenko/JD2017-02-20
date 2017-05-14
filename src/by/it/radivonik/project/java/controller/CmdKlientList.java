package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Klient;
import by.it.radivonik.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdKlientList extends AbstractActionList<Klient> {
    @Override
    protected List<Klient> getBeans() throws SQLException {
        return DAO.getInstance().getKlient().getAll("");
    }

    @Override
    protected String getParamName() {
        return "klients";
    }
}
