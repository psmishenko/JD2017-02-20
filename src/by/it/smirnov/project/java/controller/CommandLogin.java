package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.User;
import by.it.smirnov.project.java.log.SingleLogger;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandLogin extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        if (FormUtils.isPost(request) && request.getAttribute("clearform")!=Boolean.TRUE){
            try {
                String login = FormUtils.getString(request,"login",IPattern.LOGIN);
                String password = FormUtils.getString(request,"password",IPattern.PASSWORD);
                HttpSession session=FormUtils.getSession(request, login, DigestUtils.md5Hex(password));
                if (session!=null){
                    return Actions.SDELS.command;
                } else {
                    request.setAttribute(IMessages.MSG_MESSAGE,"Нет такого пользователя");
                    return null;
                }
            } catch (Exception e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
            }
            return null;
        }
        else
        {
            return null;
        }
    }
}
