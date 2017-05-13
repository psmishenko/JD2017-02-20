package by.it.prigozhanov.project.java.controller;

import by.it.prigozhanov.project.java.beans.Car;
import by.it.prigozhanov.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by v-omf on 5/13/2017!
 */
public class CommandEditCars extends Action{
    @Override
    Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        try {
            if (Form.isPost(request)) {
                if (request.getParameter("Create") != null) {
                    Car car = new Car(
                            0,
                            Form.getString(request, "mark", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getString(request, "model", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getInt(request, "hp"),
                            Form.getString(request,"location", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getInt(request, "luggagecapacity"),
                            Form.getInt(request, "price"),
                            Form.getInt(request, "seats"),
                            Form.getInt(request, "fuelconsumption")
                    );
                    dao.car.create(car);
                }
                if (request.getParameter("Update") != null) {
                    Car car = new Car(
                            Form.getInt(request, "id"),
                            Form.getString(request, "mark", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getString(request, "model", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getInt(request, "hp"),
                            Form.getString(request,"location", "[a-zA-Zа-яА-Я0-9.\\-]+"),
                            Form.getInt(request, "luggagecapacity"),
                            Form.getInt(request, "price"),
                            Form.getInt(request, "seats"),
                            Form.getInt(request, "fuelconsumption")
                    );
                    dao.car.update(car);
                }
                if (request.getParameter("Delete") != null) {
                    Car car = new Car();
                    car.setId(Form.getInt(request, "id"));
                    dao.car.delete(car);
                }



            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        List<Car> cars = null;
        try {
            cars = dao.car.getAll("");
            request.setAttribute("cars", cars);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
