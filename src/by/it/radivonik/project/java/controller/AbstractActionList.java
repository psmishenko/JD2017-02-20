package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by Radivonik on 12.05.2017.
 */
public abstract class AbstractActionList<T> extends AbstractAction {
    @Override
    AbstractAction execute(HttpServletRequest req) {
        try {
            List<T> beans = getBeans();
            req.setAttribute(getParamName(), beans);
            HttpSession session = req.getSession();
            if (session != null)
                session.setAttribute(FormUtils.actionPrevName, this);
        }
//        catch (ParseException e) {
//            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
//        }
        catch (SQLException e) {
            req.setAttribute(IMessages.MSG_ERROR, e.getMessage());
        }

        return null;
    }                ;

    protected abstract List<T> getBeans() throws SQLException;
    protected abstract String getParamName();
}
