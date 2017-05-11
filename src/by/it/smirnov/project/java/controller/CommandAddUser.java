package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddUser extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

        List<Role> listRole = null;
        try {
            listRole = dao.getRole().getAll("");
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("roles", listRole);

        if (FormUtils.isPost(request)) {
            User user=new User();
            try {
                user.setId(0);
                user.setName(FormUtils.getString(request,"name",IPattern.NAME));
                user.setLogin(FormUtils.getString(request,"login",IPattern.LOGIN));
                user.setPassword(FormUtils.getString(request,"password",IPattern.PASSWORD));
                if (dao.getUser().create(user)){
                    for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements();)
                    {
                        String paramName = e.nextElement();
                        if (paramName.indexOf("checkboxes-")==0){
                            paramName = paramName.replaceAll("checkboxes-","");
                            int idRole = Integer.valueOf(paramName);
                            UserRole userRole=new UserRole();
                            userRole.setId(0);
                            userRole.setIduser(user.getId());
                            userRole.setIdrole(idRole);
                            dao.getUserRole().create(userRole);
                        }
                    }
                    return Actions.USERS.command;

                } else
                    return null;
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
            }
        }
        return null;
    }
}