package by.it.smirnov.project.java.controller;

import by.it.smirnov.project.java.DAO.DAO;
import by.it.smirnov.project.java.bean.*;
import by.it.smirnov.project.java.log.SingleLogger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import static by.it.smirnov.project.java.controller.FormUtils.getSessionUser;

/**
 * Created by aleksey.smirnov on 05.05.2017.
 */
public class CommandActionSdel extends Action{
    private void prepareData(HttpServletRequest request, int id) throws SQLException {
        if (id != 0) {
            DAO dao = DAO.getInstance();
            Sdel sdel = dao.getSdel().read(id);
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.setAttribute("sdel",sdel);
            }
        }
    }
    @Override
    public Action execute(HttpServletRequest request, HttpServletResponse response) {
        DAO dao = DAO.getInstance();

        List<Bank> listBank = null;
        List<Valut> listValut = null;
        List<OperType> listOperType = null;
        try {
            listBank = dao.getBank().getAll("");
            listValut = dao.getValut().getAll("");
            listOperType = dao.getOperType().getAll("");
        } catch (SQLException e) {
            SingleLogger.getInstance().error(e.toString());
        }
        request.setAttribute("banks", listBank);
        request.setAttribute("valuts", listValut);
        request.setAttribute("opertypes", listOperType);

        if (FormUtils.isPost(request)) {
            int id = 0;
            try {
                if (request.getParameter("btnDelete")!=null){
                    dao.getSdel().deleteById(FormUtils.getInt(request,"id"));
                    return Actions.SDELS.command;
                } else
                if (request.getParameter("btnEdit")!=null){
                    prepareData(request, FormUtils.getInt(request, "id"));
                    return Actions.ACTIONSDEL.command;
                } else {
                    Sdel sdel = new Sdel();
                    id = FormUtils.getInt(request, "id");
                    sdel.setId(id);
                    sdel.setBank(DAO.getInstance().getBank().read(FormUtils.getInt(request, "idbank")));
                    sdel.setSumma(FormUtils.getDouble(request, "summa"));
                    sdel.setValut(DAO.getInstance().getValut().read(FormUtils.getInt(request, "idvalut")));
                    sdel.setOperType(DAO.getInstance().getOperType().read(FormUtils.getInt(request, "idopertype")));
                    sdel.setFromdate(FormUtils.getDate(request, "fromdate"));
                    sdel.setTodate(FormUtils.getDate(request, "todate"));
                    int idSysoper = 1;
                    User currentUser = getSessionUser(request);
                    if (currentUser != null) {
                        SysOper sysOper = new SysOper(0,currentUser.getId(), new Timestamp(System.currentTimeMillis()));
                        dao.getSysOper().save(sysOper);
                        idSysoper = sysOper.getId();
                    }
                    sdel.setIdsysoper(idSysoper);
                    sdel.setIdsysoperedit(1);
                    if (dao.getSdel().save(sdel))
                        return Actions.SDELS.command;
                    else
                        return null;
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