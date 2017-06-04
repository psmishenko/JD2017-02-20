//package by.it.ikavalenka.jd03_04.java.controller;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by USER on 05.05.2017.
// */
//public enum  Action {
//    SIGNUP {
//        {
//            this.command = new Command_signup();
//        }
//
//    },
//    LOGIN {
//        {
//            this.command = new Command_login();
//        }
//
//    },
//    ERROR {
//        {
//            this.command = new Command_error();
//        }
//
//    },
//    LOGOUT {
//        {
//            this.command = new Command_logout();
//        }
//
//    };
//    public String jsp = "/error.jsp";
//    public Action command;
//
//    public Action defineForm(HttpServletRequest request) {
//        String command = request.getParameter("command");
//        Action res;
//        try{
//            res= Action.valueOf(command.toUpperCase()).command;
//        } catch (Exception e){
//            res = Action.ERROR.command;
//
//        }
//        return res;
//    }
//}
