package by.it.tereshko.project.java.controller;

import by.it.tereshko.project.java.beans.Ad;
import by.it.tereshko.project.java.beans.User;
import by.it.tereshko.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CmdCreateAd extends Action {

    @Override
    public Action execute(HttpServletRequest request) {
        User user = Utils.getSessionUser(request);
        if (user == null) { //не нашли пользователя в сессии
            return Actions.LOGIN.command;
        }

        if (!Form.isPost(request)) {
            return null;
        }
        //если форма POST то пишем в базу
        else {
            Ad ad = new Ad();
            try {
                ad.setID((0));
                ad.setDescription(Form.getString(request, "Description", Pattern.ANYSTRING));
                ad.setAddress(Form.getString(request, "Address", Pattern.ANYSTRING));
                ad.setArea(Form.getDouble(request, "Area"));
                request.setAttribute(Messages.MSG_MESSAGE, "hi");
                ad.setFloor(Form.getInt(request, "Floor"));
                ad.setFloors(Form.getInt(request, "Floors"));
                ad.setPrice(Form.getDouble(request, "Price"));
                ad.setRoomCount(Form.getInt(request, "RoomCount"));
                ad.setFK_Users(user.getId());
                DAO dao = DAO.getInstance();
                if (dao.ad.create(ad))
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
