package by.it.ikavalenka.project.java.controller;

import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.dao.DAO;
import jdk.nashorn.internal.runtime.ParserException;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.text.ParseException;

public class CommandSignup extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            administrator administrator = new administrator(1, 2, 3, "test", 4, 567);
            try {
                administrator.setAdm_id(0);
                administrator.setLogin(Form.getInt(request, "login"));
                administrator.setPassword(Form.getInt(request, "password"));
                administrator.setCatalog(Form.getString(request, "catalog", Pattern.CATALOG));
                administrator.setFullOrder_id(Form.getInt(request, "order"));
                administrator.getBlackList_id_fk();
                DAO dao = DAO.getInstance();
                if (dao.administratorDAO.create(administrator))
                    return Actions.LOGIN.command;
                else
                    return null;
            } catch (ParseException e) {
                return Actions.ERROR.command;
            } catch (SQLException e) {
                return Actions.ERROR.command;
            }
        }
        if (!Form.isPost(request)){
            return
        }
        else {
            client client = new client();
            try {
                client.setClient_ID(0);
                client.setLogin(Form.getInt(request,"Login"));
                client.setPassword(Form.getInt(request,"Password"));
                client.setOrder_ID(Form.getInt(request,"Order"));
                client.setCost_order(Form.getString(request,"costOrder",Pattern.ORDER));
                DAO dao = DAO.getInstance();
                if (dao.clientDAO.create(client))
                    return Actions.LOGIN.command;
                else return null;
            }catch (ParserException e){
                return Actions.ERROR.command;
            }catch (SQLException e) {
                return Actions.ERROR.command;
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

}


