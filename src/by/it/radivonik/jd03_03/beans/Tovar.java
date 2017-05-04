package by.it.radivonik.jd03_03.beans;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class Tovar {
    private int id;
    private String name;
    private String edizm;

    public Tovar() {
    }

    public Tovar(int id, String name, String edizm) {
        this.id = id;
        this.name = name;
        this.edizm = edizm;
    }

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

    public String getEdizm() {
        return edizm;
    }

    public void setEdizm(String edizm) {
        this.edizm = edizm;
    }

    @Override
    public String toString() {
        return "Tovar{id=" + id + ", name='" + name + "', edizm='" + edizm + "'}";
    }
}
