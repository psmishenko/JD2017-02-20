package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Flight;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class CmdIndex extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        List<Flight> flights = dao.flight.getAll("");
        request.setAttribute("flights", flights);
        return null;
    }
}
