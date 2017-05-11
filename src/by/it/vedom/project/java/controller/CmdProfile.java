package by.it.vedom.project.java.controller;


import by.it.vedom.project.java.beans.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        if (Form.isPost(request) && (request.getParameter("logout") != null)) {
            HttpSession session = request.getSession();
            session.invalidate();
            return Actions.LOGIN.command;
        }
        User user= Utils.getSessionUser(request);
        if (user!=null) {
//            DAO dao= DAO.getInstance();
//            try {
//                List<Ad> ads=dao.ad.getAll("WHERE FK_users="+user.getId());
//                request.setAttribute("ads",ads);
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
        }

        return null;
    }
}
