package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Valut;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddValut extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Valut valut=new Valut();
            try {
                valut.setId(0);
                valut.setNamesokr(FormUtils.getString(request,"namesokr",IPattern.VALUT));
                valut.setNamefull(FormUtils.getString(request,"namefull",""));
                if (dao.getValut().create(valut))
                    return Actions.VALUTS.command;
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