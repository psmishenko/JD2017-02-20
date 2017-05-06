package by.it.radivonik.project.java.beans;

import java.math.BigDecimal;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class Sklad {
    private int id;
    private BigDecimal count;
    private BigDecimal cena;
    private int idTovar;
    private int idUser;

    public Sklad() {
    }

    public Sklad(int id, BigDecimal count, BigDecimal cena, int idTovar, int idUser) {
        this.id = id;
        this.count = count;
        this.cena = cena;
        this.idTovar = idTovar;
        this.idUser = idUser;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public int getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(int idTovar) {
        this.idTovar = idTovar;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        return
            "SostavNaklad{id=" + id + ", count=" + count + ", cena=" + cena + ", " +
            "idTovar=" + idTovar + ", idUser=" + idUser + "}";
    }
}
