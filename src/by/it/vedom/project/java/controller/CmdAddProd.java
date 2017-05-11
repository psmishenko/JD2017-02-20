package by.it.vedom.project.java.controller;

import by.it.vedom.project.java.beans.Product;
import by.it.vedom.project.java.beans.User;
import by.it.vedom.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

public class CmdAddProd extends Action {


    @Override
    Action execute(HttpServletRequest request) throws SQLException {
        User user = Utils.getSessionUser(request);
        if (user == null) { //не нашли пользователя в сессии
            return Actions.LOGIN.command;
        }

        if (!Form.isPost(request)) {
            return null;
        }
        //если форма POST то пишем в базу
        else {
            Product product = new Product();
            try {
                product.setId(0);
                product.setName(request, "name", Pattern.ANYSTRING);
               // product.setPrice(request, "product");
                request.setAttribute(Messages.MSG_MESSAGE, "hi");

                DAO dao = DAO.getDAO();
                if (dao.product.create(product)) {
                    return Actions.PROFILE.command;
                } else
                    return null;
            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
                return null;
            }
        }
    }
}
