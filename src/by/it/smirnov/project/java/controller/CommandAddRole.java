package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Role;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddRole extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Role role=new Role();
            try {
                role.setId(0);
                role.setName(FormUtils.getString(request,"name",""));
                if (dao.getRole().create(role))
                    return Actions.ROLES.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                SingleLogger.getInstance().error(e.toString());
                return Actions.ERROR.command;
            }

        }
        return null;
    }
}