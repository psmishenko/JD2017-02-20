package by.it.sorokoee.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    BUYGOODS{
        {
            this.command=new CmdBuyGoods();
        }
    },
    CATALOGGOOD{
        {
            this.command=new CmdCatalogGood();
        }
    },

    EDITUSERS {
        {
            this.command=new CmdEditUsers();
        }
    },
    INDEX {
        {
            this.command=new CmdIndex();
        }
    },
     SIGNUP{
         {
             this.command=new CmdSignup();
         }
     },
    LOGIN{
         {
             this.command=new CmdLogin();
         }
     },
    PROFILE {
        {
            this.command=new CmdProfile();
        }
    },
    CREATEGOOD {
        {
            this.command=new CmdCreateGood();
        }
    },

     ERROR{
         {
             this.command=new CmdError();
         }
     };
     public Action command;
     static Action defineFrom(HttpServletRequest request){
         String command=request.getParameter("command");
         if (command==null){
             command="index";
         }
         Action res;
         try {
             res=Actions.valueOf(command.toUpperCase()).command;
         }
         catch (IllegalArgumentException e) {
             res=Actions.ERROR.command;
         }
         return res;
     }

}
