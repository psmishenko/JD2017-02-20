package by.it.radivonik.project.java.beans;

/**
 * Created by aleksandr.radivonik on 16.05.2017.
 */
public class TypeNaklad {
    int id;
    String code;
    String name;

    public TypeNaklad() {
    }

    public TypeNaklad(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TypeNaklad{id=" + id + ", code='" + code + "', name='" + name + "'}";
    }
}
