package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.beans.User;
import by.it.radivonik.project.java.dao.AbstractDAO;
import by.it.radivonik.project.java.dao.DAO;
import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class CmdUserEdit extends AbstractActionEdit<User> {
    @Override
    protected User newBean() {
        return new User();
    }

    @Override
    protected AbstractDAO<User> getDAO() {
        DAO dao = DAO.getInstance();
        return dao.getUser();
    }

    @Override
    protected String getParamName() {
        return "user";
    }

    @Override
    protected boolean needCreate(User user) {
        return user.getId() == 0;
    }

    @Override
    protected void initBean(User user, int id, HttpServletRequest req) throws ParseException {
        user.setId(id);
        user.setLogin(FormUtils.getString(req, "login", IPatterns.LOGIN));
        user.setPassword(FormUtils.getString(req, "password", IPatterns.PASSWORD));
        user.setEmail(FormUtils.getString(req, "email", IPatterns.EMAIL));
        user.setIdRole(Integer.parseInt(req.getParameter("id_role")));
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.USERLIST.command;
    }
}
