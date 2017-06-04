package by.it.ikavalenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;
import by.it.ikavalenka.project.java.dao.DAO;
import by.it.ikavalenka.project.java.beans.administrator;
import jdk.nashorn.internal.runtime.ParserException;

import java.text.ParseException;

public class CommandEditCatalog extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        administrator administrator = Utils.getSessionAdministrstor(request);
        request.setAttribute("administrator",administrator);
        if (administrator!=null && administrator.getFullOrder_id() ==1){
            DAO dao = DAO.getInstance();
            try{
                if (Form.isPost(request)){
                    if (request.getParameter("Update")!=null){
                        administrator administrator1 = new administrator(
                                Form.getInt(request, "Adm_id"),
                                Form.getInt(request, "Login"),
                                Form.getInt(request,"Password"),
                                Form.getInt(request,"FullOrder_id"),
                                Form.getInt(request,"BlackList_id_fk")
                        );
                        dao.administratorDAO.update();
                    }
                    if (request.getParameter("Delete")!=null){
                        administrator administrator1 =new administrator(Form.getInt(request, "Adm_id"), Form.getInt(request, "Login"), Form.getInt(request, "Password"), Form.getInt(request, "FullOrder_id"), Form.getInt(request, "BlackList_id_fk"));
                        administrator.setAdm_id(Form.getInt(request,"Adm_id"));
                        dao.clientDAO.delete();
                    }
                }

            } catch (ParserException e){
                e.printStackTrace();
            } catch (ParseException e) {
                e.printStackTrace();
            }
            return null;
        }else return Actions.LOGIN.command;
    }
}
