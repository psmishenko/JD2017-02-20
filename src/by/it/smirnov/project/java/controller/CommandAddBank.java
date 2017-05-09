package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Bank;
import by.it.smirnov.project.java.bean.Country;
import by.it.smirnov.project.java.bean.GroupBank;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddBank extends Action{
    @Override
    public Action execute(HttpServletRequest request) {
        DAO dao = DAO.getInstance();
        if (request.getMethod().equalsIgnoreCase("GET")) {
            List<Country> listCountry = null;
            List<GroupBank> listGroupBank = null;
            try {
                listCountry = dao.getCountry().getAll("");
                listGroupBank = dao.getGroupBank().getAll("");
            } catch (SQLException e) {
                SingleLogger.getInstance().error(e.toString());
            }
            request.setAttribute("countrys", listCountry);
            request.setAttribute("groupbanks", listGroupBank);
            return null;
        }
        if (request.getMethod().equalsIgnoreCase("POST")) {
            Bank bank=new Bank();
            try {
                bank.setId(0);
                bank.setName(FormUtils.getString(request,"name",""));
                bank.setBic(FormUtils.getString(request,"bic",IPattern.BIC));
                bank.setCountry(DAO.getInstance().getCountry().read(Integer.parseInt(FormUtils.getString(request,"idcountry",""))));
                bank.setGroupBank(DAO.getInstance().getGroupBank().read(Integer.parseInt(FormUtils.getString(request,"idgroupbank",""))));
                bank.setIdsysoper(1);
                if (dao.getBank().create(bank))
                    return Actions.BANKS.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                SingleLogger.getInstance().error(e.toString());
                return Actions.ERROR.command;
            }

        }
        return null;
    }
}