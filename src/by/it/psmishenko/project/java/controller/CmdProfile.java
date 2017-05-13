package by.it.psmishenko.project.java.controller;

 import by.it.psmishenko.project.java.beans.Book;
         import by.it.psmishenko.project.java.beans.User;
         import by.it.psmishenko.project.java.dao.DAO;

         import javax.servlet.http.HttpServletRequest;
         import javax.servlet.http.HttpSession;
         import java.sql.SQLException;
         import java.util.List;


public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
               if (Form.isPost(request) && (request.getParameter("logout") != null)){
                       HttpSession session = request.getSession();
                        session.invalidate();
                        return Actions.LOGIN.command;
                    }
                User user = Utils.getSessionUser(request);
                if (user!=null){
                       DAO dao= DAO.getInstance();
                        String where = "WHERE FK_users="+user.getId();
                        try {
                                List<Book> books = dao.book.getAll(where);
                                request.setAttribute("books",books);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                    }
                return  null;
    }
}
