package by.it.Zyryanov.jd03_02.beans;

/**
 * Created by georgijzyranov on 04.05.17.
 */
public class Roles {

    private int id;
    private String Role;


    public Roles() {
    }

    public Roles(int id, String role) {
        this.id = id;
        Role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (id != roles.id) return false;
        return Role != null ? Role.equals(roles.Role) : roles.Role == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Role != null ? Role.hashCode() : 0);
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", Role='" + Role + '\'' +
                '}';
    }
}