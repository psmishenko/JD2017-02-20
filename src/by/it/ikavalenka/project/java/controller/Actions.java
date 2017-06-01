package by.it.ikavalenka.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {{
        this.command = new CommandSignup();
    }},
    LOGIN {{
        this.command = new CommandLogin();
    }},
    LOGOUT {{
        this.command = new CommandLogout();
    }},

    EDITBLACKLIST {{
        this.command =new CommandEditBlackList();
    }
    },
    EDITCATALOG{
        {
            this.command = new CommandEditCatalog();
        }
    },
    CATALOG{
        {
            this.command = new CommandCatalog();
        }
    },
    ERROR {{
        this.command = new CommandError();
    }};

    public String jsp = "/error.jsp";
    public Action command;

    static Action defineFrom(HttpServletRequest request){

        String command = request.getParameter("command");
        Action res;
        try

        {
            res = Actions.valueOf(command.toUpperCase()).command;
        }  catch
                (
                IllegalArgumentException e)

        {
            res = Actions.ERROR.command;
        }
        return res;
    }

}