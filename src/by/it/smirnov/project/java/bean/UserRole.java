package by.it.smirnov.project.java.bean;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class UserRole extends AbstractBaseClass {
    private int iduser;
    private int idrole;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdrole() {
        return idrole;
    }

    public void setIdrole(int idrole) {
        this.idrole = idrole;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserRole userRole = (UserRole) o;

        if (getId() != userRole.getId()) return false;
        if (iduser != userRole.iduser) return false;
        return idrole == userRole.idrole;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + iduser;
        result = 31 * result + idrole;
        return result;
    }

    public UserRole(int id, int iduser, int idrole) {
        setId(id);
        this.iduser = iduser;
        this.idrole = idrole;
    }

    public UserRole() {
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + getId() +
                ", iduser=" + iduser +
                ", idrole=" + idrole +
                "}";
    }
}
