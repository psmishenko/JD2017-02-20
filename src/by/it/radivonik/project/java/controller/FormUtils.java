package by.it.radivonik.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.sql.Date;
import java.text.ParseException;

/**
 * Created by Radivonik on 06.05.2017.
 */
public class FormUtils {
    static final String actionPrev = "actionPrev";

    public static String getString(
        HttpServletRequest req, String param, String pattern, boolean empty, String name) throws ParseException  {
        String value = req.getParameter(param);
        if (empty && (value == null || value.isEmpty()))
            return null;
        if (value != null && (pattern.isEmpty() || value.matches(pattern)))
            return value;
        throw new ParseException(errorMsg(value, name, pattern), 1);
    }

    public static int getId(HttpServletRequest req) {
        String id = req.getParameter("id");
        return id == null || id.isEmpty() ? 0 : Integer.parseInt(id);
    }

    public static Integer getInteger(
        HttpServletRequest req, String param, boolean empty, String name) throws ParseException  {
        String value = getString(req, param, "", empty, name);
        if (empty && (value == null || value.isEmpty()))
            return null;
        try {
            return Integer.valueOf(value);
        }
        catch (Exception e) {
            throw new ParseException(errorMsg(value, name, ""), 1);
        }
    }

    public static Date getDate(
        HttpServletRequest req, String param, boolean empty, String name) throws ParseException  {
        String value = getString(req, param, "", empty, name);
        if (empty && (value == null || value.isEmpty()))
            return null;
        try {
            return Date.valueOf(value);
        }
        catch (Exception e) {
            throw new ParseException(errorMsg(value, name, ""), 1);
        }
    }

    public static BigDecimal getDecimal(
        HttpServletRequest req, String param, boolean empty, String name) throws ParseException  {
        String value = getString(req, param, "", empty, name);
        if (empty && (value == null || value.isEmpty()))
            return null;
        try {
            return new BigDecimal(value);
        }
        catch (Exception e) {
            throw new ParseException(errorMsg(value, name, ""), 1);
        }
    }

    static String errorMsg(String value, String name, String pattern) {
        String msg = String.format("Некорректное значение в поле '%s': %s", name, value);
        if (pattern != null && !pattern.isEmpty())
            msg = msg + String.format(" (шаблон '%s')", pattern);
        return msg;
    }

    static boolean isPost(HttpServletRequest req) {
        return req.getMethod().toUpperCase().equals("POST");
    }

    static AbstractAction actionPrev(HttpServletRequest req, AbstractAction actionDefault) {
        HttpSession session = req.getSession();
        if (session == null)
            return null;
        if (session.getAttribute(actionPrev) != null) {
            AbstractAction action = (AbstractAction)session.getAttribute(actionPrev);
            session.removeAttribute(actionPrev);
            return action;
        }
        return actionDefault;
    }
}
