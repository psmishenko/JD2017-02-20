package by.it.radivonik.project.java.beans;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int idRole;
    private String nameRole;

    public User() {
    }

    public User(int id, String login, String password, String email, int idRole, String nameRole) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.idRole = idRole;
        this.nameRole = nameRole;
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

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }

    @Override
    public String toString() {
        return
            "User{id=" + id + ", login='" + login + "', password='" + password + "', " +
            "email='" + email + "', idRole=" + idRole  + ", nameRole='" + getNameRole() + "'}";
    }
}
