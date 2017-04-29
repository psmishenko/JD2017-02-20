package by.it.radivonik.jd03_02.beans;

/**
 * Created by Radivonik on 29.04.2017.
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int id_role;

    public User() {
    }

    public User(int id, String login, String password, String email, int id_role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.id_role = id_role;
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

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", id_role=" + id_role +
                '}';
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + id_role;
        return result;
    }
}
