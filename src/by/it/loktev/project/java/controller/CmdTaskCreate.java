package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Task;
import by.it.loktev.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;

public class CmdTaskCreate extends Action {

    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {

        response.setHeader("Cache-Control","no-store");

        if (!Form.isPost(request)){
            return null; // запрос методом GET - просто отобразим пустую форму
        }

        // запрос методом POST - надо добавлять

        try {

            SimpleDateFormat enterDateFormat= new SimpleDateFormat();
            enterDateFormat.applyPattern("yyyy-mm-dd");

            Task task=new Task();
            task.setId(0);
            task.setName(Form.getString(request,"name",Pattern.TASKNAME));
            task.setEndDate(enterDateFormat.parse(Form.getString(request,"enddate",Pattern.DATE)));
            task.setPrice(Float.parseFloat(Form.getString(request,"price",Pattern.FLOAT)));
            task.setStatusId(1);

            DAO dao=DAO.getInstance();
            dao.getTask().create(task);

            return Actions.TASKLIST.command;

        } catch (Exception e) {
            request.setAttribute(Messages.MSG_ERROR,e.toString());
        }
        return null;

    }
}
