package by.it.korzun.jd03_03.beans;

public class Specialization {
    private int id;
    private String specialization;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Specialization that = (Specialization) o;

        if (id != that.id) return false;
        return specialization != null ? specialization.equals(that.specialization) : that.specialization == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (specialization != null ? specialization.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return String.format("ID - %-3d %s", id, specialization);
    }

    public Specialization(int id, String specialization) {
        this.id = id;
        this.specialization = specialization;
    }

    public Specialization() {
    }
}
