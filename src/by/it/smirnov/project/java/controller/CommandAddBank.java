package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Bank;
import by.it.smirnov.project.java.bean.Country;
import by.it.smirnov.project.java.bean.GroupBank;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandAddBank extends Action{
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

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

        if (FormUtils.isPost(request)) {
            Bank bank=new Bank();
            try {
                bank.setId(0);
                bank.setName(FormUtils.getString(request,"name",IPattern.NAME));
                bank.setBic(FormUtils.getString(request,"bic",IPattern.BIC));
                bank.setCountry(DAO.getInstance().getCountry().read(FormUtils.getInt(request,"idcountry")));
                bank.setGroupBank(DAO.getInstance().getGroupBank().read(FormUtils.getInt(request,"idgroupbank")));
                bank.setIdsysoper(1);
                if (dao.getBank().create(bank))
                    return Actions.BANKS.command;
                else
                    return null;
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
            }
        }
        return null;
    }
}