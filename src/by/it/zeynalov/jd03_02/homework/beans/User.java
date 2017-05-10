package by.it.zeynalov.jd03_02.homework.beans;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fc_rolles;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getLogin() {return login;}

    public void setLogin(String login) {this.login = login;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getEmail() {return email;}

    public void setEmail(String email) {this.email = email;}

    public int getFc_rolles() {return fc_rolles;}

    public void setFc_rolles(int fc_rolles) {this.fc_rolles = fc_rolles;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User users = (User) o;

        if (id != users.id) return false;
        if (fc_rolles != users.fc_rolles) return false;
        if (login != null ? !login.equals(users.login) : users.login != null) return false;
        if (password != null ? !password.equals(users.password) : users.password != null) return false;
        return email != null ? email.equals(users.email) : users.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + fc_rolles;
        return result;
    }

    public User(int id, String login, String password, String email, int fc_rolles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fc_rolles = fc_rolles;
    }

    public User() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fc_rolles=" + fc_rolles +
                '}';
    }
}
