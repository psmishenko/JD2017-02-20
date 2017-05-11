package by.it.prigozhanov.project.java.beans;

public class User {
    private int id;
    private String passportData;
    private String login;
    private String password;
    private String email;
    private Integer fkRole;

    public User(int id, String passportData, String login, String password, String email, Integer fkRole) {
        this.id = id;
        this.passportData = passportData;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fkRole = fkRole;
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

    public Integer getFkRole() {
        return fkRole;
    }

    public void setFkRole(Integer fkRole) {
        this.fkRole = fkRole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (passportData != null ? !passportData.equals(user.passportData) : user.passportData != null) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        return fkRole != null ? fkRole.equals(user.fkRole) : user.fkRole == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (fkRole != null ? fkRole.hashCode() : 0);
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
                '}';
    }
}
