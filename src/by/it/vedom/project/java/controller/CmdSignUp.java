package by.it.vedom.project.java.controller;

import by.it.vedom.project.java.beans.User;
import by.it.vedom.project.java.dao.DAO;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;


public class CmdSignUp extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            User user = new User();
            try {
                user.setId(0);
                user.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                user.setEmail(Form.getString(request, "email", Pattern.EMAIL));
                user.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
                user.setFk_roles(2);
                DAO dao = DAO.getInstance();
                if (dao.user.create(user))
                    return Actions.LOGIN.command;
                else
                    return null;
            } catch (Exception e) {
                return Actions.ERROR.command;
            }
        }
    }

    @Test
    public static void main(String[] args) {
        User user=new User(0,"q","p","e",1);
        DAO dao = DAO.getInstance();
        try {
            dao.user.create(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
