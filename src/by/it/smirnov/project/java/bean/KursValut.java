package by.it.smirnov.project.java.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class KursValut extends AbstractBaseClass {
    private Date datekurs;
    private double za;
    private Valut zavalut;
    private double dat;
    private Valut datvalut;

    public Date getDatekurs() {
        return datekurs;
    }

    public void setDatekurs(Date datekurs) {
        this.datekurs = datekurs;
    }

    public double getZa() {
        return za;
    }

    public void setZa(double za) {
        this.za = za;
    }

    public Valut getZavalut() {
        return zavalut;
    }

    public void setZavalut(Valut zavalut) {
        this.zavalut = zavalut;
    }

    public double getDat() {
        return dat;
    }

    public void setDat(double dat) {
        this.dat = dat;
    }

    public Valut getDatvalut() {
        return datvalut;
    }

    public void setDatvalut(Valut datvalut) {
        this.datvalut = datvalut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KursValut kursValut = (KursValut) o;

        if (getId() != kursValut.getId()) return false;
        if (Double.compare(kursValut.za, za) != 0) return false;
        if (zavalut.getId() != kursValut.zavalut.getId()) return false;
        if (Double.compare(kursValut.dat, dat) != 0) return false;
        if (datvalut.getId() != kursValut.datvalut.getId()) return false;
        return datekurs != null ? datekurs.equals(kursValut.datekurs) : kursValut.datekurs == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (datekurs != null ? datekurs.hashCode() : 0);
        temp = Double.doubleToLongBits(za);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + zavalut.getId();
        temp = Double.doubleToLongBits(dat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + datvalut.getId();
        return result;
    }

    public KursValut(int id, Date datekurs, double za, Valut zavalut, double dat, Valut datvalut) {
        setId(id);
        this.datekurs = datekurs;
        this.za = za;
        this.zavalut = zavalut;
        this.dat = dat;
        this.datvalut = datvalut;
    }

    public KursValut() {
    }

    @Override
    public String toString() {
        return "KursValut{" +
                "id=" + getId() +
                ", datekurs=" + datekurs +
                ", za=" + za +
                ", zavalut=" + zavalut.getNamesokr() +
                ", dat=" + dat +
                ", datvalut=" + datvalut.getNamesokr() +
                "}";
    }
}
