package by.it.ikavalenka.project.java.controller;

import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CommandLogin extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        if (!Form.isPost(request)) {
            return null;
        } else {
            client client = new client();
            client.setClient_ID(0);
            try {
                client.setLogin(Form.getInt(request, "Login"));
                client.setPassword(Form.getInt(request, "Password"));
                DAO dao = DAO.getInstance();
                String ShowCredentials = String.format("Where Login='%s' and Password='%s'", client.getLogin(), client.getPassword());
                List<client> clientList = dao.clientDAO.getAll(ShowCredentials);
                if (clientList.size() == 1) {
                    HttpSession session = request.getSession();
                    session.setMaxInactiveInterval(80000);
                    client = clientList.get(0);
                    session.setAttribute("client", client);
                    return Actions.SIGNUP.command;
                } else {
                    request.setAttribute(Messages.MSG_MESSAGE, "Client  with this  name does not exist");
                    return null;
                }
            } catch (Exception e) {
                e.getMessage();
            }
            if (!Form.isPost(request)) {
            } else {
                administrator administrator = new administrator(1, 2, 3, "test", 4, 567);
                administrator.setAdm_id(0);
                try {
                    administrator.setLogin(Form.getInt(request, "Login"));
                    administrator.setPassword(Form.getInt(request, "Password"));
                    DAO dao = DAO.getInstance();
                    String ShowCredentials = String.format("Where Login='%s' and Password='%s'", administrator.getLogin(), administrator.getPassword());
                    List<administrator> administratorList = dao.administratorDAO.getAll(ShowCredentials);
                    if (administratorList.size() == 1) {
                        HttpSession session = request.getSession();
                        session.setMaxInactiveInterval(80000);
                        administrator = administratorList.get(0);
                        session.setAttribute("administrator", administrator);
                        return Actions.SIGNUP.command;
                    } else {
                        request.setAttribute(Messages.MSG_MESSAGE, "Administrator  with this  name does not exist");
                        return null;
                    }
                } catch (Exception e) {
                    e.getMessage();
                }
            }
            return null;
        }
    }
}
