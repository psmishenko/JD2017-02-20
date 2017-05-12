package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.Bank;
import by.it.smirnov.project.java.bean.Country;
import by.it.smirnov.project.java.bean.GroupBank;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionBank extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            Bank bank = dao.getBank().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("bank",bank);
            }
        }
    }
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
            int id = 0;
            try {
                if (request.getParameter("btnDelete")!=null){
                    dao.getBank().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.BANKS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONBANK.command;
                } else {
                    Bank bank=new Bank();
                    id = FormUtils.getInt(request, "id");
                    bank.setId(id);
                    bank.setName(FormUtils.getString(request, "name", IPattern.NAME));
                    bank.setBic(FormUtils.getString(request, "bic", IPattern.BIC));
                    bank.setCountry(DAO.getInstance().getCountry().read(FormUtils.getInt(request, "idcountry")));
                    bank.setGroupBank(DAO.getInstance().getGroupBank().read(FormUtils.getInt(request, "idgroupbank")));
                    bank.setIdsysoper(1);
                    if (dao.getBank().save(bank))
                        return Actions.BANKS.command;
                    else {
                        return null;
                    }
                }
            } catch (ParseException|SQLException e) {
                request.setAttribute(IMessages.MSG_ERROR,e.toString());
                SingleLogger.getInstance().error(e.toString());
                try {prepareData(request, id);} catch (Exception ex) {}
            }
        }
        return null;
    }
}