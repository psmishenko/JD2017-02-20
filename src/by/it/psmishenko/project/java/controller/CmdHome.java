package by.it.psmishenko.project.java.controller;



import javax.servlet.http.HttpServletRequest;


 class CmdHome extends Action {
    @Override
    public Action execute(HttpServletRequest request) {
        if(Utils.getSessionUser(request)==null) return Actions.INDEX.command;
         else return null;
    }
}
