package by.it.vedom.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    private RequestDispatcher dispatcher(Action action) {
        return getServletContext().getRequestDispatcher(action.getJsp());
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //возвращает null в случае успешной обработки, иначе по GET браузеру сообщает о том, чтобы он посылал новую команду

        Action action=Actions.defineFrom(req);
        Action nextAction= null;
        try {
            nextAction = action.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (nextAction != null){
            resp.sendRedirect("do?command="+nextAction);
        }
        else
        {
            dispatcher(action).forward(req,resp);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Action action = Actions.defineFrom(req);
        try {
            action.execute(req);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        action.equals(req);
        dispatcher(action).forward(req, resp);

        process(req, resp);
    }


    private void process(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException {

//        ServletContext servletContext = getServletContext();
//        RequestDispatcher disp = servletContext.getRequestDispatcher("/index.jsp");
//        disp.forward(req, resp);
    }
}
