package by.it.kolenda.project.java.controller;


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
    ERROR {{
        this.command = new CommandError();
    }};

    public String jsp = "/error.jsp";
    public ActionComand command;

    public ActionComand getCurrentCommand()

    {
        return command;
    }

    ;


}
