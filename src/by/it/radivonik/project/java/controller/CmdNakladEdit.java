package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.*;
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
        User user = DAO.getInstance().getUser().read(FormUtils.getInteger(req, "id_user", false, "Пользователь"));
        TypeNaklad type = DAO.getInstance().getTypeNaklad().read(FormUtils.getInteger(req, "id_type", false, "Тип накладной"));
        Klient klient = DAO.getInstance().getKlient().read(FormUtils.getInteger(req, "id_klient", false, "Клиент"));
        Integer idAvto = FormUtils.getInteger(req, "id_avto", true, "Автомобиль");
        Avto avto = DAO.getInstance().getAvto().read(idAvto==null?0:idAvto);
        return new Naklad(
            FormUtils.getId(req),
            FormUtils.getDate(req, "date", false, "Дата товарной накладной"),
            FormUtils.getString(req, "num", IPatterns.NUM, false, "Номер товарной накладной"),
            FormUtils.getString(req, "seria", IPatterns.SERIA, false, "Серия товарной накладной"),
            user,
            type,
            klient,
            avto);
    }

    @Override
    protected int getId(Naklad tovar) {
        return tovar.getId();
    }

    @Override
    protected AbstractAction getActionPrevDefault() {
        return Actions.NAKLADLIST.command;
    }
}
