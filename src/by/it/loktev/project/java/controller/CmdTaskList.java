package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Role;
import by.it.loktev.project.java.beans.Status;
import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class CmdTaskList extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");


        try {
            DAO dao=DAO.getInstance();
            List<Task> list= dao.getTask().getAll("");
            //Log.write("list "+((list==null)?"null":"not null"));
            //Log.write("list size "+list.size());
            //Log.write("list str "+list.toString());
            request.setAttribute("tasks",list);
            //request.setAttribute("taskslist",list.toString());
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
            //Log.write("EXCEPTION: "+e.toString());
            //e.printStackTrace();
        }

        return null;
    }
}
