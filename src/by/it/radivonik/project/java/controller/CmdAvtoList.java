package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Avto;
import by.it.radivonik.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdAvtoList extends AbstractActionList<Avto> {
    @Override
    protected List<Avto> getBeans() throws SQLException {
        return DAO.getInstance().getAvto().getAll("");
    }

    @Override
    protected String getParamName() {
        return "avtos";
    }
}
