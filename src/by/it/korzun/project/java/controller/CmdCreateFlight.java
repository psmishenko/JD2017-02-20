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

            String sql = String.format("WHERE `Brigades_ID` = %d", flight.getBrigadeID());

            DAO dao = DAO.getInstance();
            if(dao.flight.getAll(sql).size() == 0 && dao.flight.create(flight)){
                return Actions.ADMIN.command;
            }else
                return Actions.ADMIN.command;
        } catch (ParseException e) {
            return Actions.ERROR.command;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.ADMIN.command;
    }

}
