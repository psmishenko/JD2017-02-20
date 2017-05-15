package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Naklad;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Radivonik on 15.05.2017.
 */
public class CmdNakladEdit extends AbstractActionEdit<Naklad> {
    @Override
    protected Naklad newBean() {
        return new Naklad();
    }

    @Override
    protected AbstractDAO<Naklad> getDAO() {
        return DAO.getInstance().getNaklad();
    }

    @Override
    protected String getName() {
        return "naklad";
    }

    @Override
    protected Naklad initBean(HttpServletRequest req) throws ParseException, SQLException {
        return null;
//        return new Naklad(
//            FormUtils.getId(req),
//            FormUtils.getString(req, "name", IPatterns.TEXT, false, "Наименование товара"),
//            FormUtils.getString(req, "edizm", IPatterns.TEXT, false, "Единица измерения"));
    }

    @Override
    protected int getId(Naklad tovar) {
        return tovar.getId();
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.NAKLADLIST.command;
    }
}
