package by.it.vedom.project.java.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class FrontController extends HttpServlet {

    private RequestDispatcher dispatcher(Action action){
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        Action nextAction;
        try {
            nextAction = action.execute(req);
            if (nextAction != null){
                resp.sendRedirect("do?command="+nextAction);
            }
            else
            {
                dispatcher(action).forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Action action=Actions.defineFrom(req);
        Action nextAction;
        try {
            nextAction = action.execute(req);
            if (nextAction != null){
                resp.sendRedirect("do?command="+nextAction);
            }
            else
            {
                dispatcher(action).forward(req,resp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ServletContext servletContext=getServletContext();
//        RequestDispatcher disp=servletContext.getRequestDispatcher("/index.jsp");
//        disp.forward(req,resp);
    }
}
