package by.it.korzun.project.java.controller;


import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdSignUp extends Action{


    @Override
    public Action execute(HttpServletRequest request) {
        Staff staff = new Staff();
        try {
            staff.setId(0);
            staff.setName(Form.getString(request, "name", Pattern.NAME));
            staff.setLogin(Form.getString(request, "login", Pattern.LOGIN));
            staff.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
            staff.setFk_specialization(Integer.parseInt(Form.getString(request, "specialization",
                    Pattern.SPECIALIZATION)));
            DAO dao = DAO.getInstance();
            if(dao.staff.create(staff)){
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
