package by.it.ikavalenka.project.java.controller;


import javax.servlet.http.HttpServletRequest;
import by.it.ikavalenka.project.java.beans.administrator;
import by.it.ikavalenka.project.java.beans.blacklist;
import by.it.ikavalenka.project.java.beans.client;
import by.it.ikavalenka.project.java.dao.DAO;
import jdk.nashorn.internal.runtime.ParserException;

import java.text.ParseException;
import java.util.List;

public class CommandEditBlackList extends Action {
    public Action execute(HttpServletRequest request) {

        client client = Utils.getSessionClient(request);
        request.setAttribute("client", client);
        if (client != null && client.getOrder_ID() == 1) {
            DAO dao = DAO.getInstance();
            try {
                if (Form.isPost(request)) {
                    if (request.getParameter("Update") != null) {
                        client client1 = new client(
                                Form.getInt(request, "Client_ID"),
                                Form.getInt(request, "Login"),
                                Form.getInt(request, "Password"),
                                Form.getInt(request, "order_ID"),
                                Form.getString(request, "cost_order", Pattern.ORDER)
                        );
                        dao.clientDAO.update();
                    }
                    if (request.getParameter("Delete") != null) {
                        client client1 = new client();
                        client.setClient_ID(Form.getInt(request, "Client_ID"));
                        dao.clientDAO.delete();
                    }
                }

            } catch (ParserException e) {
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        } else return Actions.LOGIN.command;
    }
}