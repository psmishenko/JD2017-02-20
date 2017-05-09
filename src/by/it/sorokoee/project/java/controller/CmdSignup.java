package by.it.sorokoee.project.java.controller;


import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;

public class CmdSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        User user=new User();
        try {
            user.setId(0);
            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
            user.setEmail(Form.getString(request,"email",Pattern.EMAIL));
            user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
            user.setFk_roles(2);
            DAO dao=DAO.getDAO();
            if (dao.user.create(user))
                return Actions.LOGIN.command;
            else
                return null;
        }
        catch (ParseException e){
            return Actions.ERROR.command;
        }
    }
}

