package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Staff;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CmdProfile extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Staff staff;
        if(session.getAttribute("staff") != null) {
            staff = (Staff) session.getAttribute("staff");
        }else{
            return Actions.LOGIN.command;
        }
        Object ob = request.getSession();
        if(ob != null && (staff.getFk_specialization() == 1 ||
                staff.getFk_specialization() == 2 ||
                staff.getFk_specialization() == 3 ||
                staff.getFk_specialization() == 4)
                ){
            return Actions.STAFF.command;
        }else if(ob != null && staff.getFk_specialization() == 5){
            return Actions.DISPATCHER.command;
        }else if(ob != null && staff.getFk_specialization() == 6){
            return Actions.ADMIN.command;
        }else {
            return Actions.LOGIN.command;
        }
    }
}
