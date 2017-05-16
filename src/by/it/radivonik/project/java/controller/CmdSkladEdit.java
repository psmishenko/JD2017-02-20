package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.Sklad;
import by.it.radivonik.project.java.beans.Tovar;
import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Radivonik on 14.05.2017.
 */
public class CmdSkladEdit extends AbstractActionEdit<Sklad> {
    @Override
    protected Sklad newBean() {
        return new Sklad();
    }

    @Override
    protected AbstractDAO<Sklad> getDAO() {
        return DAO.getInstance().getSklad();
    }

    @Override
    protected String getName() {
        return "sklad";
    }

    @Override
    protected Sklad initBean(HttpServletRequest req) throws ParseException, SQLException {
        Tovar tovar = DAO.getInstance().getTovar().read(FormUtils.getInteger(req, "id_tovar", false, "Товар"));
        User user = DAO.getInstance().getUser().read(FormUtils.getInteger(req, "id_user", false, "Пользователь"));
        return new Sklad(
            FormUtils.getId(req),
            FormUtils.getDecimal(req, "count", false, "Количество"),
            FormUtils.getDecimal(req, "cena", false, "Цена"),
            tovar,
            user);
    }

    @Override
    protected int getId(Sklad sklad) {
        return sklad.getId();
    }

    @Override
    protected AbstractAction getActionPrevDefault() {
        return Actions.SKLADLIST.command;
    }
}
