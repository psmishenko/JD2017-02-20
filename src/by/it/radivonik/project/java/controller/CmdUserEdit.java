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
        return DAO.getInstance().getUser();
    }

    @Override
    protected String getName() {
        return "user";
    }


    @Override
    protected User initBean(HttpServletRequest req) throws ParseException {
        return new User(
            FormUtils.getId(req),
            FormUtils.getString(req, "login", IPatterns.LOGIN, false, "Имя пользователя"),
            FormUtils.getString(req, "password", IPatterns.PASSWORD, false, "Пароль"),
            FormUtils.getString(req, "email", IPatterns.EMAIL, true, "Адрес электронной почты"),
            FormUtils.getInteger(req, "id_role", false, "Роль"),
            "");
    }

    @Override
    protected int getId(User user) {
        return user.getId();
    }

    @Override
    protected AbstractAction getActionReturn() {
        return Actions.USERLIST.command;
    }
}
