package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

public class CmdTaskEdit extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        // запрос методом POST
        // параметр taskid
        // если есть buttonsave - это уже сохранение

        int taskId = Integer.parseInt(request.getParameter("taskid"));
        DAO dao = DAO.getInstance();

        if ( request.getParameter("buttonsave")==null ) {

            // заполняем форму старыми значениями
            try {

                //Log.write("task edit id=" + taskId);
                Task task = dao.getTask().read(taskId);
                request.setAttribute("task", task);
                request.setAttribute("taskid", taskId);
                request.setAttribute("statuses",dao.getStatus().getAll(""));
                request.setAttribute("users",dao.getUser().getAll(""));
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

                Task task=new Task();
                task.setId(taskId);
                task.setName(Form.getString(request,"name",Pattern.TASKNAME));
                task.setEndDate(enterDateFormat.parse(Form.getString(request,"enddate",Pattern.DATE)));
                task.setPrice(Float.parseFloat(Form.getString(request,"price",Pattern.FLOAT)));
                task.setStatusId(Integer.parseInt(request.getParameter("status")));
                task.setExecUserId(Integer.parseInt(request.getParameter("execuser")));

                dao.getTask().update(task);

                return Actions.TASKLIST.command;

            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR,e.toString());
            }

        }

        return null;
    }
}
