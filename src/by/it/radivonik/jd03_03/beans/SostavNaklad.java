package by.it.radivonik.jd03_03.beans;

import java.math.BigDecimal;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class SostavNaklad {
    private int id;
    private int npp;
    private BigDecimal count;
    private BigDecimal cena;
    private BigDecimal prnds;
    private int idNaklad;
    private int idTovar;

    public SostavNaklad() {
    }

    public SostavNaklad(int id, int npp, BigDecimal count, BigDecimal cena, BigDecimal prnds, int idNaklad, int idTovar) {
        this.id = id;
        this.npp = npp;
        this.count = count;
        this.cena = cena;
        this.prnds = prnds;
        this.idNaklad = idNaklad;
        this.idTovar = idTovar;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNpp() {
        return npp;
    }

    public void setNpp(int npp) {
        this.npp = npp;
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

    public BigDecimal getPrnds() {
        return prnds;
    }

    public void setPrnds(BigDecimal prnds) {
        this.prnds = prnds;
    }

    public int getIdNaklad() {
        return idNaklad;
    }

    public void setIdNaklad(int idNaklad) {
        this.idNaklad = idNaklad;
    }

    public int getIdTovar() {
        return idTovar;
    }

    public void setIdTovar(int idTovar) {
        this.idTovar = idTovar;
    }

    @Override
    public String toString() {
        return
            "SostavNaklad{id=" + id + ", npp=" + npp + ", count=" + count + ", cena=" + cena + ", prnds=" + prnds + ", " +
            "idNaklad=" + idNaklad + ", idTovar=" + idTovar + "}";
    }
}
