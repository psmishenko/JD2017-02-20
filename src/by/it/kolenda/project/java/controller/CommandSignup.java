package by.it.kolenda.project.java.controller;

import javax.servlet.http.HttpServletRequest;


public class CommandSignup extends Action{

    @Override
    public Action execute(HttpServletRequest request)

    {
        User user = new User();
        user.setId(0);
        user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
        user.setLogin(Form.getString(request,"email",Pattern.EMAIL));
        user.setLogin(Form.getString(request,"password",Pattern.PASSWORD));
        user.setFk_Role(2);
        DAO dao = DAO.getDAO();
        if (dao.user.create(user))
            return Actions.LOGIN.command;


        return Actions.ERROR.command;
    }
}

