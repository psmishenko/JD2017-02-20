package by.it.korzun.project.java.beans;

import by.it.korzun.project.java.dao.SpecDAO;

import java.sql.SQLException;

public class Staff {
    private int id;
    private String name;
    private String login;
    private String password;
    private int fk_specialization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getFk_specialization() {
        return fk_specialization;
    }

    public void setFk_specialization(int fk_specialization) {
        this.fk_specialization = fk_specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Staff staff = (Staff) o;

        if (id != staff.id) return false;
        if (fk_specialization != staff.fk_specialization) return false;
        if (name != null ? !name.equals(staff.name) : staff.name != null) return false;
        if (login != null ? !login.equals(staff.login) : staff.login != null) return false;
        return password != null ? password.equals(staff.password) : staff.password == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + fk_specialization;
        return result;
    }

    @Override
    public String toString() {
        SpecDAO dao = new SpecDAO();
        try {
            return String.format("ID - %-3d Name - %-16s Specialization - %-15s", id, name, dao.read(fk_specialization));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Staff(int id, String name, String login, String password, int fk_specialization) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.fk_specialization = fk_specialization;
    }

    public Staff() {
    }
}
