package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        try {
            String test=Form.getString(request,"login",Pattern.LOGIN);
            request.setAttribute(Messages.MSG_MESSAGE,"test="+test);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,"error");
        }
        return null;

    }
}
