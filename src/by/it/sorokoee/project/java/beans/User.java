package by.it.sorokoee.project.java.beans;

public class User {
    private int id=0;
    private String login;
    private String password;
    private String email;
    private int fk_roles=0;

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_roles() {
        return fk_roles;
    }

    public void setFk_roles(int fk_roles) {
        this.fk_roles = fk_roles;
    }



    public User(int id, String login, String password, String email, Integer fk_roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_roles = fk_roles;
    }



    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fk_roles=" + fk_roles +
                '}';
    }
}
