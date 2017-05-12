package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.Role;
import by.it.loktev.project.java.dao.DAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

public class FrontController extends HttpServlet {

    static {
        Log.write("START");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);

        try {
            DAO dao=DAO.getInstance();
            List<Role> roles= dao.getRole().getAll("");
            config.getServletContext().setAttribute("roles",roles);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private RequestDispatcher dispatcher(Action action){
        return getServletContext().getRequestDispatcher(action.getJsp());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);

        Log.write("GET "+req.getRequestURL()+" "+req.getQueryString());

        Action action=Actions.defineFrom(req);
        //action.execute(req,resp);
        //dispatcher(action).forward(req,resp);
        Action nextAction=action.execute(req,resp);
        if ( nextAction!=null ){
            resp.sendRedirect("do?command="+nextAction);
        }
        else {
            dispatcher(action).forward(req,resp);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        process(req, resp);

        Log.write("POST "+req.getRequestURL()+" (command)="+req.getParameter("command"));

        Action action=Actions.defineFrom(req);
        Action nextAction=action.execute(req,resp);
        if ( nextAction!=null ){
            resp.sendRedirect("do?command="+nextAction);
        }
        else {
            dispatcher(action).forward(req,resp);
        }

    }

    private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        ServletContext servletContext=getServletContext();
//        RequestDispatcher disp=servletContext.getRequestDispatcher("/index.jsp");
//        disp.forward(req,resp);

    }
}
