package by.it.loktev.project.java.controller;

import by.it.loktev.project.java.beans.User;
import by.it.loktev.project.java.dao.DAO;
import org.apache.commons.codec.digest.DigestUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class Lib {

    public static boolean authorize(HttpServletRequest request, User user) throws SQLException, ParseException {

        DAO dao=DAO.getInstance();
        List<User> list=dao.getUser().getAll(" where login='"+user.getLogin()+"' and passhash='"+user.getPassHash()+"' ");
        if ( list.size()==1 ){
            HttpSession session=request.getSession();
            user=list.get(0);
            session.setAttribute("userauthorized",true);
            session.setAttribute("userid",user.getId());
            session.setAttribute("userlogin",user.getLogin());
            session.setAttribute("userpasshash", user.getPassHash());
            session.setAttribute("userroleid", user.getRoleId());
            session.setMaxInactiveInterval(30);
            return true;
        }

        return false;
    }

    public static int getUserId(HttpServletRequest request)  {

        HttpSession session=request.getSession();
        Object userIdStr=session.getAttribute("userid");
        if ( userIdStr==null )
            return -1;
        return Integer.parseInt(userIdStr.toString());
    }

}
