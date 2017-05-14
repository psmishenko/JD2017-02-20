package by.it.zeynalov.project.java.Controller;

import by.it.zeynalov.project.java.beans.Orders;
import by.it.zeynalov.project.java.beans.User;
import by.it.zeynalov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdOrders extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        User user = Utils.getSessionUser(request);
        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (!Form.isPost(request)) {
            return null;
        } else {
            Orders ad = new Orders();
            try {
                ad.setID((0));
                request.setAttribute(Messages.MSG_MESSAGE, "hi");
                ad.setLatte(Form.getString(request, "Latte", Pattern.ANYSTRING));
                ad.setAmericano(Form.getString(request, "Americano", Pattern.ANYSTRING));
                ad.setCappuccino(Form.getString(request, "Cappuccino", Pattern.ANYSTRING));
                ad.setEspresso(Form.getString(request, "Espresso", Pattern.ANYSTRING));
                DAO dao = DAO.getInstance();
                if (dao.orders.create(ad))
                    return Actions.PROFILE.command;
                else
                    return null;
            } catch (Exception e) {
                request.setAttribute(Messages.MSG_ERROR, e.toString());
                return null;
            }
        }
    }
}
