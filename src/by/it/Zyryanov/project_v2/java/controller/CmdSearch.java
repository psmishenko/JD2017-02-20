package by.it.Zyryanov.project_v2.java.controller;




import by.it.Zyryanov.project_v2.java.beans.Books;
import by.it.Zyryanov.project_v2.java.dao.Books_DAO;
import by.it.Zyryanov.project_v2.java.dao.DAO;


import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class CmdSearch extends Action {

    @Override
    Action execute(HttpServletRequest request) {
        List<Books> books = new Books_DAO().getAll("");
        if (!Form.isGet(request)) {
            return null;
        }
        try {
            DAO dao = DAO.getDao();
            request.setAttribute(Messages.MSG_MESSAGE, books.get(32));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Actions.SEARCH.command;
    }
}
