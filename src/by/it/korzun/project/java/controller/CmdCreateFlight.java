package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Flight;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateFlight extends Action{

    @Override
    Action execute(HttpServletRequest request) {
        Flight flight = new Flight();
        try {
            flight.setId(0);
            flight.setDestination(Form.getString(request, "destination",
                    Pattern.DESTINATION));
            flight.setBrigadeID(Integer.parseInt(Form.getString(request, "brigade",
                    Pattern.ID)));
            DAO dao = DAO.getInstance();
            if(dao.flight.create(flight)){
                return Actions.ADMIN.command;
            }else
                return null;
        } catch (ParseException e) {
            return Actions.ERROR.command;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.ADMIN.command;
    }

}
