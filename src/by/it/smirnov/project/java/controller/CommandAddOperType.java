package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.OperType;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddOperType extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();
        if (FormUtils.isPost(request)) {
            OperType operType=new OperType();
            try {
                operType.setId(0);
                operType.setName(FormUtils.getString(request,"name",IPattern.NAME));
                if (dao.getOperType().create(operType))
                    return Actions.OPERTYPES.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
            }
        }
        return null;
    }
}