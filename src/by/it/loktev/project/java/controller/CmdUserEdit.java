package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

public class CmdUserEdit extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        // запрос методом POST
        // параметр userid
        // если есть buttonsave - это уже сохранение

        int userId = Integer.parseInt(request.getParameter("usid"));
        DAO dao = DAO.getInstance();

        if ( request.getParameter("buttonsave")==null ) {

            // заполняем форму старыми значениями
            try {

                //Log.write("task edit id=" + taskId);
                User user = dao.getUser().read(userId);
                request.setAttribute("us", user);
                request.setAttribute("usid", userId);
                request.setAttribute("roles",dao.getRole().getAll(""));
                return null;

            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
            }
        }
        else {

            // сохраняем значения

            try {
                SimpleDateFormat enterDateFormat= new SimpleDateFormat();
                enterDateFormat.applyPattern("yyyy-MM-dd");

                User user = dao.getUser().read(userId);
                user.setLogin(request.getParameter("login"));
                user.setEmail(request.getParameter("email"));
                user.setRoleId(Integer.parseInt(request.getParameter("role")));

                dao.getUser().update(user);

                return Actions.USERLIST.command;

            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
            }

        }

        return null;
    }
}
