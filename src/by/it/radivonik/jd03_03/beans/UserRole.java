package by.it.radivonik.jd03_03.beans;

/**
 * Created by Radivonik on 05.05.2017.
 */
public class UserRole extends User{
    private String nameRole;

    public UserRole() {
    }

    public UserRole(int id, String login, String password, String email, int idRole, String nameRole) {
        super(id, login, password, email, idRole);
        this.nameRole = nameRole;
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
            "User{id=" + getId() + ", login='" + getLogin() + "', password='" + getPassword() + "', " +
            "email='" + getEmail() + "', idRole=" + getIdRole() + "', nameRole='" + getNameRole() + "'}";
    }
}
