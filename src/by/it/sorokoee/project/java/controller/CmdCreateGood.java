package by.it.sorokoee.project.java.controller;

import by.it.sorokoee.project.java.beans.Good;
import by.it.sorokoee.project.java.beans.User;
import by.it.sorokoee.project.java.daouniv.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateGood extends Action {
    @Override
    Action execute(HttpServletRequest request) {
        User user = Utils.getSessionUser(request);
        if (user == null) {
            return Actions.LOGIN.command;
        }

        if (!Form.isPost(request)) {
            return null;
        } else {

            Good good = new Good();
            try {
//                if (user.getFk_roles()==1) {

                    good.setId((0));
                    good.setModelCar(Form.getString(request, "modelCar", Pattern.ANYSTRING));
                good.setYearOfIssue(Form.getInt(request, "yearOfIssue"));
                    good.setSpare(Form.getString(request, "spare", Pattern.ANYSTRING));

                    good.setTypeEngine(Form.getString(request, "typeEngine", Pattern.ANYSTRING));
                    good.setCapacityEngine(Form.getInt(request, "capacityEngine"));
                    good.setFk_users(user.getId());
//                }
                    DAO dao = DAO.getInstance();

                if (dao.good.create(good))
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
