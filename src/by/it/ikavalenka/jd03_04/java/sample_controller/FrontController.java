package by.it.ikavalenka.jd03_04.java.sample_controller;


        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServlet;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import java.io.IOException;
        import java.io.PrintWriter;

public class FrontController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter prn=resp.getWriter();
        prn.println("<br><br>DEMO: It is Sample Front Controller!");
        prn.println("<br><br>Please create Your Front Controller!");
        prn.println("<br><br>URI:"+req.getRequestURI());
        prn.flush();
    }

}
