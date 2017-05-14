package by.it.loktev.project.java.beans;

import by.it.loktev.project.java.dao.DAO;

import java.sql.SQLException;
import java.util.List;

public class User {

    private int id;
    private String login;
    private String passHash;
    private String email;
    private int roleId;

    public User() {
    }

    public User(int id, String login, String passHash, String email, int roleId) {
        this.id = id;
        this.login = login;
        this.passHash = passHash;
        this.email = email;
        this.roleId = roleId;
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

    public String getPassHash() {
        return passHash;
    }

    public void setPassHash(String passHash) {
        this.passHash = passHash;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName(){
        try {
            DAO dao=DAO.getInstance();
            List<Role> roles= dao.getRole().getAll(" id="+roleId+" ");
            if ( roles.size()==1 )
                return roles.get(0).getName();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "???";
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", passhash='" + passHash + '\'' +
                ", email='" + email + '\'' +
                ", roleId=" + roleId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (roleId != user.roleId) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        if (passHash != null ? !passHash.equals(user.passHash) : user.passHash != null) return false;
        return email != null ? email.equals(user.email) : user.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (passHash != null ? passHash.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + roleId;
        return result;
    }
}
