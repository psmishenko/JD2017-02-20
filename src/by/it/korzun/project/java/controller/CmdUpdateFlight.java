package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Flight;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdUpdateFlight extends Action{
    @Override
    Action execute(HttpServletRequest request) {
        Flight flight = new Flight();

        try {
            flight.setId(Integer.parseInt(Form.getString(request, "id",
                    Pattern.ID)));
            flight.setDestination(Form.getString(request, "destination",
                    Pattern.DESTINATION));
            flight.setBrigadeID(Integer.parseInt(Form.getString(request, "brigadeid",
                    Pattern.ID)));
            DAO dao = DAO.getInstance();
            if(dao.flight.update(flight)){
                request.setAttribute(Messages.MSG_MESSAGE, "Successful Update");
                return Actions.ADMIN.command;
            }else {
                request.setAttribute(Messages.MSG_MESSAGE, "Not successful Update");
                return Actions.ADMIN.command;
            }
        } catch (ParseException | SQLException e) {
            request.setAttribute(Messages.MSG_MESSAGE, "Not successful Update. Check, if brigade exists");
            return Actions.ADMIN.command;
        }
    }
}
