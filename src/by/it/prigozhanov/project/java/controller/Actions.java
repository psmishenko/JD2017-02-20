package by.it.prigozhanov.project.java.controller;

import javax.servlet.http.HttpServletRequest;

enum Actions {
    SIGNUP {
        {
            this.command = new CommandSignup();
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
        }
    },
    PROFILE {
        {
            this.command = new CommandProfile();
        }
    },
    ERROR {
        {
            this.command = new CommandError();
        }
    },
    RENTCAR {
        {
            this.command = new CommandRentCar();
        }
    },
    SEARCH {
        {
            this.command = new CommandSearch();
        }
    },
    HOME {
        {
            this.command = new CommandHome();
        }
    },
    INDEX {
        {
            this.command = new CommandIndex();
        }
    },
    EDITUSERS {
        {
            this.command = new CommandEditUsers();
        }
    },
    CARS {
        {
            this.command = new CommandCars();
        }
    };
    public Action command;

    static Action defineFrom(HttpServletRequest request) {
        String command = request.getParameter("command");
        if (command==null) {
            command="index";
        }
        Action res;
        try {

            res = Actions.valueOf(command.toUpperCase()).command;
        } catch (IllegalArgumentException e) {
            res=Actions.ERROR.command;
        }
        return res;

    }

}
