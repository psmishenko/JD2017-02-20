package by.it.vedom.project.java.beans;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fk_roles;

    public User() {
    }

    public User(int id, String login, String password, String email, int fk_roles) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_roles = fk_roles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (fk_roles != user.fk_roles) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;
        return email.equals(user.email);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + fk_roles;
        return result;
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
