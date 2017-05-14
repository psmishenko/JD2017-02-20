package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class CmdTaskDelete extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        int taskId = Integer.parseInt(request.getParameter("taskid"));
        Log.write("удаляется задача "+taskId);
        DAO dao = DAO.getInstance();
        try {
            Task task=new Task();
            task.setId(taskId);
            dao.getTask().delete(task);

            return Actions.TASKLIST.command;
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }

        return null;
    }
}
