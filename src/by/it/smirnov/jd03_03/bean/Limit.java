package by.it.smirnov.jd03_03.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Limit extends AbstractBaseClass {
    private int idgroupbank;
	private Date fromdate;
    private int idopertype;
    private double summa;
    private int idvalut;
    private int idsysoper;

    public int getIdgroupbank() {
        return idgroupbank;
    }

    public void setIdgroupbank(int idgroupbank) {
        this.idgroupbank = idgroupbank;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public int getIdopertype() {
        return idopertype;
    }

    public void setIdopertype(int idopertype) {
        this.idopertype = idopertype;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public int getIdvalut() {
        return idvalut;
    }

    public void setIdvalut(int idvalut) {
        this.idvalut = idvalut;
    }

    public int getIdsysoper() {
        return idsysoper;
    }

    public void setIdsysoper(int idsysoper) {
        this.idsysoper = idsysoper;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Limit limit = (Limit) o;

        if (getId() != limit.getId()) return false;
        if (idgroupbank != limit.idgroupbank) return false;
        if (idopertype != limit.idopertype) return false;
        if (Double.compare(limit.summa, summa) != 0) return false;
        if (idvalut != limit.idvalut) return false;
        if (idsysoper != limit.idsysoper) return false;
        return fromdate != null ? fromdate.equals(limit.fromdate) : limit.fromdate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + idgroupbank;
        result = 31 * result + (fromdate != null ? fromdate.hashCode() : 0);
        result = 31 * result + idopertype;
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idvalut;
        result = 31 * result + idsysoper;
        return result;
    }

    public Limit(int id, int idgroupbank, Date fromdate, int idopertype, double summa, int idvalut, int idsysoper) {
        setId(id);
        this.idgroupbank = idgroupbank;
        this.fromdate = fromdate;
        this.idopertype = idopertype;
        this.summa = summa;
        this.idvalut = idvalut;
        this.idsysoper = idsysoper;
    }

    public Limit() {
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + getId() +
                ", idgroupbank=" + idgroupbank +
                ", fromdate=" + fromdate +
                ", idopertype=" + idopertype +
                ", summa=" + summa +
                ", idvalut=" + idvalut +
                ", idsysoper=" + idsysoper +
                "}";
    }
}
