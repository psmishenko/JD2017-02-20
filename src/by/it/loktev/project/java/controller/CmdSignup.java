package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSignup extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        User user=new User();
        try {
            user.setId(0);
            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
            user.setEmail(Form.getString(request,"email",Pattern.EMAIL));
            user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
            user.setRoleId(2);
            DAO dao=DAO.getInstance();
            if  ( dao.getUser().create(user) ){
                return Actions.LOGIN.command;
            } else {
                return null;
            }
        } catch (ParseException e) {
            return Actions.ERROR.command;
        } catch (SQLException e) {
            return Actions.ERROR.command;
        }

    }
}
