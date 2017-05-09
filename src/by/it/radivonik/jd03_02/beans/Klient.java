package by.it.radivonik.jd03_02.beans;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class Klient {
    private int id;
    private String name;
    private String unp;
    private String adres;

    public Klient() {
    }

    public Klient(int id, String name, String unp, String adres) {
        this.id = id;
        this.name = name;
        this.unp = unp;
        this.adres = adres;
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

    public String getUnp() {
        return unp;
    }

    public void setUnp(String unp) {
        this.unp = unp;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }
    @Override
    public String toString() {
        return "Klient{id=" + id + ", name='" + name + ", unp='" + unp + "', adres='" + adres + "'}";
    }
}
