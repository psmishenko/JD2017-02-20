package by.it.prigozhanov.project.java.beans;

/**
 * Created by v-omf on 4/29/2017!
 */
public class User {

    private int id;
    private String passportData;
    private String login;
    private String password;
    private String email;
    private Integer fkRole;
    private Integer fkCar;

    public User(int id, String passportData, String login, String password, String email, Integer fkRole, Integer fkCar) {
        this.id = id;
        this.passportData = passportData;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fkRole = fkRole;
        this.fkCar = fkCar;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
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

    public int getFkRole() {
        return fkRole;
    }

    public void setFkRole(int fkRole) {
        this.fkRole = fkRole;
    }

    public int getFkCar() {
        return fkCar;
    }

    public void setFkCar(int fkCar) {
        this.fkCar = fkCar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (fkRole != user.fkRole) return false;
        if (fkCar != user.fkCar) return false;
        if (passportData != null ? !passportData.equals(user.passportData) : user.passportData != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + fkRole;
        result = 31 * result + fkCar;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", passportData='" + passportData + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fkRole=" + fkRole +
                ", fkCar=" + fkCar +
                '}';
    }
}
