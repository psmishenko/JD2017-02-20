package by.it.korzun.project.java.controller;

import by.it.korzun.project.java.beans.Brigade;
import by.it.korzun.project.java.beans.Staff;
import by.it.korzun.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;

public class CmdCreateBrigade extends Action{

    @Override
    Action execute(HttpServletRequest request) {
        Brigade brigade = new Brigade();
        try {
            brigade.setId(0);
            brigade.setFirstPilotID(Integer.parseInt(Form.getString(request, "firstpilot",
                    Pattern.ID)));
            brigade.setSecondPilotID(Integer.parseInt(Form.getString(request, "secondpilot",
                    Pattern.ID)));
            brigade.setNavigatorID(Integer.parseInt(Form.getString(request, "navigator",
                    Pattern.ID)));
            brigade.setRadio_operatorID(Integer.parseInt(Form.getString(request, "radio_operator",
                    Pattern.ID)));
            brigade.setStewardessID(Integer.parseInt(Form.getString(request, "stewardess",
                    Pattern.ID)));

            String sql = String.format("WHERE `firstPilotID` = %d OR " +
                                        "`secondPilotID` = %d OR " +
                                        "`firstPilotID` = %d OR " +
                                        "`secondPilotID` = %d OR " +
                                        "`navigatorID` = %d OR " +
                                        "`radio_operatorID` = %d OR " +
                                        "`stewardessID` = %d",
                    brigade.getFirstPilotID(),
                    brigade.getSecondPilotID(),
                    brigade.getSecondPilotID(),
                    brigade.getFirstPilotID(),
                    brigade.getNavigatorID(),
                    brigade.getRadio_operatorID(),
                    brigade.getStewardessID()
            );

            DAO dao = DAO.getInstance();

            boolean isSpecCorrect = true;

            String sqlCheck = String.format("WHERE `ID` = %d", brigade.getFirstPilotID());
            Staff staff = dao.staff.getAll(sqlCheck).get(0);
            if(staff.getFk_specialization() != 1){
                isSpecCorrect = false;
            }
            sqlCheck = String.format("WHERE `ID` = %d", brigade.getSecondPilotID());
            staff = dao.staff.getAll(sqlCheck).get(0);
            if(staff.getFk_specialization() != 1){
                isSpecCorrect = false;
            }
            sqlCheck = String.format("WHERE `ID` = %d", brigade.getNavigatorID());
            staff = dao.staff.getAll(sqlCheck).get(0);
            if(staff.getFk_specialization() != 2){
                isSpecCorrect = false;
            }
            sqlCheck = String.format("WHERE `ID` = %d", brigade.getRadio_operatorID());
            staff = dao.staff.getAll(sqlCheck).get(0);
            if(staff.getFk_specialization() != 3){
                isSpecCorrect = false;
            }
            sqlCheck = String.format("WHERE `ID` = %d", brigade.getStewardessID());
            staff = dao.staff.getAll(sqlCheck).get(0);
            if(staff.getFk_specialization() != 4){
                isSpecCorrect = false;
            }

            if(dao.brigade.getAll(sql).size() == 0 && isSpecCorrect && dao.brigade.create(brigade)){
                return Actions.DISPATCHER.command;
            }else
                return Actions.DISPATCHER.command;
        } catch (ParseException e) {
            return Actions.ERROR.command;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Actions.DISPATCHER.command;
    }
}
