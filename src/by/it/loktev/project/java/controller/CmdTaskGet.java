package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class CmdTaskGet extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        int taskId = Integer.parseInt(request.getParameter("taskid"));
        DAO dao = DAO.getInstance();
        try {
            Task task=dao.getTask().read(taskId);
            task.setExecUserId(Lib.getUserId(request));
            task.setStatusId(2);
            dao.getTask().update(task);

            return Actions.TASKLIST.command;
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }

        return null;
    }
}
