package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Valut;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddValut extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();
        if (FormUtils.isPost(request)) {
            Valut valut=new Valut();
            try {
                valut.setId(0);
                valut.setNamesokr(FormUtils.getString(request,"namesokr",IPattern.VALUT));
                valut.setNamefull(FormUtils.getString(request,"namefull",IPattern.NAME));
                if (dao.getValut().create(valut))
                    return Actions.VALUTS.command;
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