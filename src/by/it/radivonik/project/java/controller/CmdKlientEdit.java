package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Avto;
import by.it.radivonik.project.java.beans.Klient;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdKlientEdit extends AbstractActionEdit<Klient> {
    @Override
    protected Klient newBean() {
        return new Klient();
    }

    @Override
    protected AbstractDAO<Klient> getDAO() {
        return DAO.getInstance().getKlient();
    }

    @Override
    protected String getName() {
        return "klient";
    }

    @Override
    protected Klient initBean(HttpServletRequest req) throws ParseException, SQLException {
        return new Klient(
            FormUtils.getId(req),
            FormUtils.getString(req, "name", IPatterns.TEXT, false, "Наименование клиента"),
            FormUtils.getString(req, "unp", IPatterns.UNP, false, "УНП"),
            FormUtils.getString(req, "adres", IPatterns.TEXT, false, "Адрес"));
    }

    @Override
    protected int getId(Klient klient) {
        return klient.getId();
    }

    @Override
    protected AbstractAction getActionPrevDefault() {
        return Actions.KLIENTLIST.command;
    }

    @Override
    protected void execAfter(HttpServletRequest req) throws SQLException {
        List<Klient> klients = getDAO().getAll("");
        req.getServletContext().setAttribute("klients_spr", klients);
    }
}
