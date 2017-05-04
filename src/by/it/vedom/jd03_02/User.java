package by.it.vedom.jd03_02;

public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int role_role_id;

    public User() {
    }

    public User(int id, String login, String password, String email, int role_role_id) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role_role_id = role_role_id;
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

    public int getRole_role_id() {
        return role_role_id;
    }

    public void setRole_role_id(int role_role_id) {
        this.role_role_id = role_role_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (role_role_id != user.role_role_id) return false;
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
        result = 31 * result + role_role_id;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role_role_id=" + role_role_id +
                '}';
    }
}
