package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        if (!Form.isPost(request)){
            return null;
        }

        try {
            User user=new User();
            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
            user.setPassHash(DigestUtils.md5Hex(Form.getString(request,"password",Pattern.PASSWORD)));
            if ( Lib.authorize(request,user) ) {
                return Actions.PROFILE.command;
            }
            request.setAttribute(Messages.MSG_MESSAGE,"нет такого пользователя");
            return null;
        } catch (Exception e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }
        return null;

    }
}
