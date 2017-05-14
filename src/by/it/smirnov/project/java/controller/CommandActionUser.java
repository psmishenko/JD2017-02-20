package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Enumeration;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionUser extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            User user = dao.getUser().read(id);
            List<UserRole> userRole = dao.getUserRole().getAll(String.format(" WHERE IDUSER = %d", id));
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("user",user);
                session.setAttribute("userroles",userRole);
            }
        }
    }

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
            int id = 0;
            try {
                if (request.getParameter("btnDelete")!=null){
                    dao.getUser().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.USERS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONUSER.command;
                } else {
                    User user=new User();
                    id = FormUtils.getInt(request, "id");
                    user.setId(id);
                    user.setName(FormUtils.getString(request, "name", IPattern.NAME));
                    user.setLogin(FormUtils.getString(request, "login", IPattern.LOGIN));
                    user.setPassword(FormUtils.getString(request, "password", IPattern.PASSWORD));
                    if (dao.getUser().save(user)) {
                        List<UserRole> userRoles = dao.getUserRole().getAll(String.format(" WHERE IDUSER = %d", user.getId()));
                        for (UserRole userRole:userRoles) {
                            dao.getUserRole().deleteById(userRole.getId());
                        }
                        for (Enumeration<String> e = request.getParameterNames(); e.hasMoreElements(); ) {
                            String paramName = e.nextElement();
                            if (paramName.indexOf("checkboxes-") == 0) {
                                paramName = paramName.replaceAll("checkboxes-", "");
                                int idRole = Integer.valueOf(paramName);
                                UserRole userRole = new UserRole();
                                userRole.setId(0);
                                userRole.setIduser(user.getId());
                                userRole.setIdrole(idRole);
                                dao.getUserRole().save(userRole);
                            }
                        }
                        return Actions.USERS.command;

                    } else
                        return null;
                }
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
                try {prepareData(request, id);} catch (Exception ex) {}
            }
        }
        return null;
    }
}