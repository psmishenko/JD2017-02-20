package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Brigade;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdRemoveBrigade extends Action{
    @Override
    Action execute(HttpServletRequest request) {
        try {
            DAO dao = DAO.getInstance();
            Brigade brigade = dao.brigade.read(Integer.parseInt(Form.getString(request, "id", Pattern.ID)));

            if(dao.brigade.delete(brigade)){
                return Actions.DISPATCHER.command;
            }else
                return Actions.DISPATCHER.command;
        } catch (SQLException | ParseException e) {
            return Actions.DISPATCHER.command;
        }
    }
}
