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
        DAO dao = DAO.getInstance();
        return dao.getTovar();
    }

    @Override
    protected String getParamName() {
        return "tovar";
    }

    @Override
    protected boolean needCreate(Tovar tovar) {
        return tovar.getId() == 0;
    }

    @Override
    protected void initBean(Tovar tovar, int id, HttpServletRequest req) throws ParseException {
        tovar.setId(id);
        tovar.setName(FormUtils.getString(req, "name", IPatterns.TEXT));
        tovar.setEdizm(FormUtils.getString(req, "edizm", IPatterns.TEXT));
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.TOVARLIST.command;
    }

}
