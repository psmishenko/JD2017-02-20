package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Brigade;
import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CmdDispatcher extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        if(Form.isPost(request) && (request.getParameter("logout") != null)){
            HttpSession session = request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }

        DAO dao = DAO.getInstance();
        List<Brigade> brigades = dao.brigade.getAll("");
        request.setAttribute("brigades", brigades);

        List<Staff> staff = dao.staff.getAll("");
        request.setAttribute("staffs", staff);

        return null;
    }
}
