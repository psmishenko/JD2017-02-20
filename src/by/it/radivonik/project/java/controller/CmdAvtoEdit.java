package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Avto;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdAvtoEdit extends AbstractActionEdit<Avto> {
    @Override
    protected Avto newBean() {
        return new Avto();
    }

    @Override
    protected AbstractDAO<Avto> getDAO() {
        return DAO.getInstance().getAvto();
    }

    @Override
    protected String getName() {
        return "avto";
    }

    @Override
    protected Avto initBean(HttpServletRequest req) throws ParseException, SQLException {
        return new Avto(
            FormUtils.getId(req),
            FormUtils.getString(req, "numgos", IPatterns.NUMGOS, false, "Гос. номер"),
            FormUtils.getString(req, "voditel", IPatterns.TEXT, false, "Водитель (ФИО)"));
    }

    @Override
    protected int getId(Avto avto) {
        return avto.getId();
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.AVTOLIST.command;
    }

    @Override
    protected void execAfter(HttpServletRequest req) throws SQLException {
        List<Avto> avtos = getDAO().getAll("");
        req.getServletContext().setAttribute("avtos_spr", avtos);
    }
}
