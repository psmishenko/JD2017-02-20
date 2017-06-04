//package by.it.ikavalenka.jd03_04.java.controller;
//
//import javax.servlet.RequestDispatcher;
//import javax.servlet.ServletContext;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//
///**
// * Created by USER on 05.05.2017.
// */
//public class FrontController extends HttpServlet {
//        private RequestDispatcher dispetcher(ActionOne action){
//            return getServletContext().getRequestDispatcher(action.getJsp());
//        }
//
//    @Override
//    protected long getLastModified(HttpServletRequest req) {
//        return super.getLastModified(req);
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ActionOne  action = Action.defineForm(req);
//        action.execute(req);
//        dispetcher(action).forward(req,resp);
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        ActionOne  action = Action.defineForm(req);
//        ActionOne nextAction = action.execute(req);
//        if(nextAction !=null){
//            resp.sendRedirect("do?command=" + nextAction);
//        }
//        else
//        {
//            dispetcher(action).forward(req,resp);
//        }
//    }
//
//    private void process (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
////        PrintWriter out = resp.getWriter();
////        out.println("FrontController");
////        out.flush();
//        ServletContext servletContext = getServletContext();
//        RequestDispatcher disp = servletContext.getRequestDispatcher("/index.jsp");
//        disp.forward(req,resp);
//    }
//}
