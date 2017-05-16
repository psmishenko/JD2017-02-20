package by.it.radivonik.project.java.controller;

import by.it.radivonik.project.java.dao.InterfaceDAO;
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

        T bean = null;
        try {
            if (action.equals("create"))
                bean = newBean();
            else
                bean = getDAO().read(FormUtils.getId(req));

            if (action.equals("create") || action.equals("update") || action.equals("delete")) {
                req.setAttribute(getName(), bean);
                return null;
            }

            bean = initBean(req);

            if (action.equals("create_exec"))
                getDAO().create(bean);
            else if (action.equals("update_exec"))
                getDAO().update(bean);
            else if (action.equals("delete_exec"))
                getDAO().delete(bean);

            if (!action.equals("delete_exec"))
                req.getSession().setAttribute(getName() + "_id", getId(bean));
            else
                req.getSession().removeAttribute(getName() + "_id");

            execAfter(req);
            return FormUtils.actionPrev(req, getActionPrevDefault());
        }
        catch (ParseException e) {
            req.setAttribute(getName(), bean);
            req.setAttribute("action", action);
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        catch (SQLException e) {
            req.setAttribute(getName(), bean);
            req.setAttribute("action", action);
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }
        return  null;
    }

    protected abstract T newBean();
    protected abstract InterfaceDAO<T> getDAO();
    protected abstract String getName();
    protected abstract T initBean(HttpServletRequest req) throws ParseException, SQLException;
    protected abstract int getId(T bean);
    protected abstract AbstractAction getActionPrevDefault();
    protected void execAfter(HttpServletRequest req) throws SQLException {

    };
}
