package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Brigade;
import by.it.korzun.project.java.beans.Flight;
import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class CmdStaff extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        if(Form.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }

        Staff staff = (Staff)request.getSession().getAttribute("staff");
        String sql = "";
        if(staff.getFk_specialization() == 1) {
            sql = String.format("WHERE firstPilotID = %d OR secondPilotID = %d",
                    staff.getId(), staff.getId());
        }else if(staff.getFk_specialization() == 2) {
            sql = String.format("WHERE navigatorID = %d", staff.getId());
        }else if(staff.getFk_specialization() == 3) {
            sql = String.format("WHERE radio_operatorID = %d", staff.getId());
        }else if(staff.getFk_specialization() == 4) {
            sql = String.format("WHERE stewardessID = %d", staff.getId());
        }

        DAO dao = DAO.getInstance();
        Brigade brigade;
        if(sql != "" && dao.brigade.getAll(sql).size() != 0){
            brigade = dao.brigade.getAll(sql).get(0);
            request.setAttribute("brigade", "Assigned to brigade " + brigade.getId());
            sql = String.format("WHERE brigades_id = %d", brigade.getId());
            Flight flight;
            if(dao.flight.getAll(sql).size() != 0){
                flight = dao.flight.getAll(sql).get(0);
                request.setAttribute("flight", String.format(
                        "Attached to flight %d. Destination: %s",
                        flight.getId(), flight.getDestination()));
            }else{
                request.setAttribute("flight", "Not attached to any flight");
            }
        }else {
            request.setAttribute("brigade", "Not assigned to any brigade");
        }

        return null;
    }

}
