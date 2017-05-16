package by.it.psmishenko.project.java.controller;

 import by.it.psmishenko.project.java.beans.Book;
         import by.it.psmishenko.project.java.beans.User;
         import by.it.psmishenko.project.java.dao.DAO;

         import javax.servlet.http.HttpServletRequest;
         import javax.servlet.http.HttpSession;
         import java.sql.SQLException;
 import java.text.ParseException;
 import java.util.List;


public class CmdProfile extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
               if (Form.isPost(request) && (request.getParameter("logout") != null)){
                       HttpSession session = request.getSession();
                        session.invalidate();
                        return Actions.LOGIN.command;
                    }

        int start=0;
        if (request.getParameter("start")!=null){
            try {
                start=Form.getInt(request,"start");
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

                User user = Utils.getSessionUser(request);
                if (user!=null){
                    try {
                       DAO dao= DAO.getInstance();
                        String where = "WHERE FK_users="+user.getId();
                    int bookCount=dao.book.getAll(where).size();
                        request.setAttribute("bookCount",bookCount);
                        String limit=String.format(" ORDER BY ID LIMIT %d,5 ",start);
                        List<Book> books = dao.book.getAll(where+limit);
                        request.setAttribute("books",books);
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                    }
                return  null;
    }
}
