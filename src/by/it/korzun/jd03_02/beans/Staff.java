package by.it.korzun.jd03_02.beans;

import by.it.korzun.jd03_02.crud.SpecCRUD;

import java.sql.SQLException;

public class Staff {
    private int id;
    private String name;
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
        return name != null ? name.equals(staff.name) : staff.name == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + fk_specialization;
        return result;
    }

    @Override
    public String toString() {
        try {
            return "ID - " + id +
                    ", Name - " + name +
                    ", Specialization - " + SpecCRUD.read(fk_specialization);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "";
    }

    public Staff(int id, String name, int fk_specialization) {
        this.id = id;
        this.name = name;
        this.fk_specialization = fk_specialization;
    }

    public Staff() {
    }
}
