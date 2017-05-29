package by.it.ikavalenka.project.java.controller;

import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignup extends Action{
    @Override
    public Action execute(HttpServletRequest request){
        administrator administrator = new administrator();
        try {
            administrator.setAdm_id(0);
            administrator.setLogin(Form.getInt(request, "login"));
            administrator.setPassword(Form.getInt(request, "password"));
            administrator.setCatalog(Form.getString(request,"catalog",Pattern.CATALOG));
            administrator.setFullOrder_id(Form.getInt(request,"order"));
            administrator.getBlackList_id_fk();
            DAO dao = DAO.getInstance();
            if (dao.administratorDAO.create(administrator))
                return Actions.LOGIN.command;
            else
                return null;
        } catch (ParseException e){
            return Actions.ERROR.command;
        } catch (SQLException e){
            return Actions.ERROR.command;
        }
    }
}


