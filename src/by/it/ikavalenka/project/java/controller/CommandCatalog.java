package by.it.ikavalenka.project.java.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import by.it.ikavalenka.project.java.dao.DAO;
import by.it.ikavalenka.project.java.beans.client;


import java.sql.SQLException;
import java.util.List;


public class CommandCatalog extends Action {
    @Override
    public Action execute(HttpServletRequest request){
        DAO dao = DAO.getInstance();
        List<client> clients;
        try {
            clients = dao.clientDAO.getAll("");
            request.setAttribute("clients", clients);

            if (request.getParameter("Client_ID")!= null){
                HttpSession session = request.getSession();
                session.setAttribute("Client_ID",request.getParameter("Client_ID"));
                clients = dao.clientDAO.getAll("WHERE order_ID="+request.getParameter("Client_ID"));

                if (clients.size() >=1){
                    request.setAttribute(Messages.MSG_MESSAGE,"You already complete the same order, for repeat order send number of order to administrator");
                    return null;
                }
                return Actions.ERROR.command;
            }

        } catch (SQLException e){
            e.printStackTrace();
        } return Actions.CATALOG.command;
        }
    }
