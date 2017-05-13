package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.util.List;

public class CmdLogin extends Action{


    @Override
    public Action execute(HttpServletRequest request) {
        if(!Form.isPost(request)){
            return null;
        }else{
            Staff staff = new Staff();
            staff.setId(0);
            try {
                staff.setLogin(Form.getString(request, "login", Pattern.LOGIN));
                staff.setPassword(Form.getString(request, "password", Pattern.PASSWORD));
                staff.setName("");
                DAO dao = DAO.getInstance();
                String where = String.format(" WHERE Login = '%s' AND Password = '%s'",
                        staff.getLogin(),
                        staff.getPassword()
                );
                List<Staff> list = dao.staff.getAll(where);
                if(list.size() == 1){
                    HttpSession session = request.getSession();
                    staff = list.get(0);
                    if(staff.getFk_specialization() == 1 ||
                            staff.getFk_specialization() == 2 ||
                            staff.getFk_specialization() == 3 ||
                            staff.getFk_specialization() == 4
                            ) {
                        session.setAttribute("staff", staff);
                        return Actions.STAFF.command;
                    }else if(staff.getFk_specialization() == 5){
                        session.setAttribute("staff", staff);
                        return Actions.DISPATCHER.command;
                    }else if(staff.getFk_specialization() == 6){
                        session.setAttribute("staff", staff);
                        return Actions.ADMIN.command;
                    }
                }else{
                    request.setAttribute(Messages.MSG_MESSAGE, "Wrong login or password");
                    return null;
                }

            } catch (ParseException e) {
                request.setAttribute(Messages.MSG_MESSAGE, e.toString());
                e.printStackTrace();
            }

        }
        return null;
    }
}
