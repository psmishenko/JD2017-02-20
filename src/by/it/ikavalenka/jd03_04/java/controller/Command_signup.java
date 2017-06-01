//package by.it.ikavalenka.jd03_04.java.controller;
//
//import jdk.nashorn.internal.runtime.ParserException;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by USER on 05.05.2017.
// */
//public class Command_signup implements ActionOne
//    {
//        @Override
//        public Action execute (HttpServletRequest request){
//            User user = new User();
//            user.setLogin(Form.getString(request,"login",Pattern.LOGIN));
//            user.setEmail(Form.getString(request,"email",Pattern.EMAIL));
//            user.setPassword(Form.getString(request,"password",Pattern.PASSWORD));
//          user.setFk_Role(2);
//          DAO dao = DAO.getDAO(user);
//          return Action.LOGIN.command;
//          else
//              return null;
//    } catch (ParserException e) {
//            return Action.ERROR.command;
//    }
//    return Action.LOGIN.command;
//    }