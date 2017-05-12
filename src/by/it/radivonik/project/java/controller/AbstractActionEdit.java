package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.dao.AbstractDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

/**
 * Created by Radivonik on 12.05.2017.
 */
public abstract class AbstractActionEdit<T> extends AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) {
        String action = req.getParameter("action").toLowerCase();
        if (!FormUtils.isPost(req) || action == null)
            return Actions.ERROR.command;

        String idStr = req.getParameter("id");
        int id = idStr.isEmpty() ? 0 : Integer.parseInt(idStr);

        try {
            T bean;
            if (id == 0)
                bean = newBean();
            else
                bean = getDAO().read(id);

            if (action.equals("delete")) {
                getDAO().delete(bean);
                return getActionReturn();
            }

            if (action.equals("create") || action.equals("update")) {
                req.setAttribute(getParamName(), bean);
                return null;
            }

            if (action.equals("save")) {
                initBean(bean, id, req);

                if (needCreate(bean))
                    getDAO().create(bean);
                else
                    getDAO().update(bean);

                return getActionReturn();
            }
        }
        catch (ParseException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        return  null;
    }

    protected abstract T newBean();
    protected abstract AbstractDAO<T> getDAO();
    protected abstract String getParamName();
    protected abstract boolean needCreate(T bean);
    protected abstract void initBean(T bean, int id, HttpServletRequest req) throws ParseException;
    protected abstract AbstractAction getActionReturn();
}
