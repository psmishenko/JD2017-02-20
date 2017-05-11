package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Brigade;
import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateBrigade extends Action{

    @Override
    Action execute(HttpServletRequest request) {
        Brigade brigade = new Brigade();
        try {
            brigade.setId(0);
            brigade.setFirstPilotID(Integer.parseInt(Form.getString(request, "firstpilot",
                    Pattern.SPECIALIZATION)));
            brigade.setSecondPilotID(Integer.parseInt(Form.getString(request, "secondpilot",
                    Pattern.SPECIALIZATION)));
            brigade.setNavigatorID(Integer.parseInt(Form.getString(request, "navigator",
                    Pattern.SPECIALIZATION)));
            brigade.setRadio_operatorID(Integer.parseInt(Form.getString(request, "radio_operator",
                    Pattern.SPECIALIZATION)));
            brigade.setStewardessID(Integer.parseInt(Form.getString(request, "stewardess",
                    Pattern.SPECIALIZATION)));
            DAO dao = DAO.getInstance();
            if(dao.brigade.create(brigade)){
                return Actions.LOGIN.command;
            }else
                return null;
        } catch (ParseException e) {
            return Actions.ERROR.command;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.LOGIN.command;
    }
}
