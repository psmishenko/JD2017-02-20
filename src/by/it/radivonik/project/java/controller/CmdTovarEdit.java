package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Tovar;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Radivonik on 12.05.2017.
 */
public class CmdTovarEdit extends AbstractActionEdit<Tovar> {
    @Override
    protected Tovar newBean() {
        return new Tovar();
    }

    @Override
    protected AbstractDAO<Tovar> getDAO() {
        return DAO.getInstance().getTovar();
    }

    @Override
    protected String getName() {
        return "tovar";
    }

    @Override
    protected Tovar initBean(HttpServletRequest req) throws ParseException {
        return new Tovar(
            FormUtils.getId(req),
            FormUtils.getString(req, "name", IPatterns.TEXT, false, "Наименование товара"),
            FormUtils.getString(req, "edizm", IPatterns.TEXT, false, "Единица измерения"));
    }

    @Override
    protected int getId(Tovar tovar) {
        return tovar.getId();
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.TOVARLIST.command;
    }
}
