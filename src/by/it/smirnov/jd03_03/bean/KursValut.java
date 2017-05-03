package by.it.smirnov.jd03_03.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class KursValut extends AbstractBaseClass {
    private Date datekurs;
    private double za;
    private int idzavalut;
    private double dat;
    private int iddatvalut;

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

    public int getIdzavalut() {
        return idzavalut;
    }

    public void setIdzavalut(int idzavalut) {
        this.idzavalut = idzavalut;
    }

    public double getDat() {
        return dat;
    }

    public void setDat(double dat) {
        this.dat = dat;
    }

    public int getIddatvalut() {
        return iddatvalut;
    }

    public void setIddatvalut(int iddatvalut) {
        this.iddatvalut = iddatvalut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KursValut kursValut = (KursValut) o;

        if (getId() != kursValut.getId()) return false;
        if (Double.compare(kursValut.za, za) != 0) return false;
        if (idzavalut != kursValut.idzavalut) return false;
        if (Double.compare(kursValut.dat, dat) != 0) return false;
        if (iddatvalut != kursValut.iddatvalut) return false;
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
        result = 31 * result + idzavalut;
        temp = Double.doubleToLongBits(dat);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + iddatvalut;
        return result;
    }

    public KursValut(int id, Date datekurs, double za, int idzavalut, double dat, int iddatvalut) {
        setId(id);
        this.datekurs = datekurs;
        this.za = za;
        this.idzavalut = idzavalut;
        this.dat = dat;
        this.iddatvalut = iddatvalut;
    }

    public KursValut() {
    }

    @Override
    public String toString() {
        return "KursValut{" +
                "id=" + getId() +
                ", datekurs=" + datekurs +
                ", za=" + za +
                ", idzavalut=" + idzavalut +
                ", dat=" + dat +
                ", iddatvalut=" + iddatvalut +
                "}";
    }
}
