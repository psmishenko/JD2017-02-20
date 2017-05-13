package by.it.sorokoee.project.java.controller;

import by.it.sorokoee.project.java.beans.Good;
import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.daouniv.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class CmdEditGoods extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            if (Form.isPost(request)) {
                if (request.getParameter("Update") != null) {
                    Good good = new Good(
                            Form.getInt(request, "id"),
                            Form.getString(request, "modelCar", Pattern.ANYSTRING),
                            Form.getInt(request, "yearOfIssue"),
                    Form.getString(request, "spare", Pattern.ANYSTRING),
                    Form.getString(request, "typeEngine", Pattern.ANYSTRING),
                            Form.getInt(request, "capacityEngine")
                    );
                    dao.good.update(good);
                }
                if (request.getParameter("Delete") != null) {
                    Good good = new Good();
                    good.setId(Form.getInt(request, "id"));
                    dao.good.delete(good);
                }
            }

            List<Good> goods = dao.good.getAll("");
//            request.getServletContext().setAttribute("roles", roles);
            request.setAttribute("goods", goods);
        } catch (ParseException e) {
            request.setAttribute(Messages.MSG_ERROR,e);
            e.printStackTrace();
        } catch (SQLException e) {
            request.setAttribute(Messages.MSG_ERROR,e);
            e.printStackTrace();
        }
        return null;
    }
}
