package by.it.smirnov.jd03_03.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Sdel extends AbstractBaseClass {
    private int idbank;
    private double summa;
    private int idvalut;
    private int idopertype;
	private Date fromdate;
    private Date todate;
    private int idsysoper;
    private int idsysoperedit;

    public int getIdbank() {
        return idbank;
    }

    public void setIdbank(int idbank) {
        this.idbank = idbank;
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

    public int getIdopertype() {
        return idopertype;
    }

    public void setIdopertype(int idopertype) {
        this.idopertype = idopertype;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public Date getTodate() {
        return todate;
    }

    public void setTodate(Date todate) {
        this.todate = todate;
    }

    public int getIdsysoper() {
        return idsysoper;
    }

    public void setIdsysoper(int idsysoper) {
        this.idsysoper = idsysoper;
    }

    public int getIdsysoperedit() {
        return idsysoperedit;
    }

    public void setIdsysoperedit(int idsysoperedit) {
        this.idsysoperedit = idsysoperedit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Sdel sdel = (Sdel) o;

        if (getId() != sdel.getId()) return false;
        if (idbank != sdel.idbank) return false;
        if (Double.compare(sdel.summa, summa) != 0) return false;
        if (idvalut != sdel.idvalut) return false;
        if (idopertype != sdel.idopertype) return false;
        if (idsysoper != sdel.idsysoper) return false;
        if (idsysoperedit != sdel.idsysoperedit) return false;
        if (fromdate != null ? !fromdate.equals(sdel.fromdate) : sdel.fromdate != null) return false;
        return todate != null ? todate.equals(sdel.todate) : sdel.todate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + idbank;
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + idvalut;
        result = 31 * result + idopertype;
        result = 31 * result + (fromdate != null ? fromdate.hashCode() : 0);
        result = 31 * result + (todate != null ? todate.hashCode() : 0);
        result = 31 * result + idsysoper;
        result = 31 * result + idsysoperedit;
        return result;
    }

    public Sdel(int id, int idbank, double summa, int idvalut, int idopertype, Date fromdate, Date todate, int idsysoper, int idsysoperedit) {
        setId(id);
        this.idbank = idbank;
        this.summa = summa;
        this.idvalut = idvalut;
        this.idopertype = idopertype;
        this.fromdate = fromdate;
        this.todate = todate;
        this.idsysoper = idsysoper;
        this.idsysoperedit = idsysoperedit;
    }

    public Sdel() {
    }

    @Override
    public String toString() {
        return "Sdel{" +
                "id=" + getId() +
                ", idbank=" + idbank +
                ", summa=" + summa +
                ", idvalut=" + idvalut +
                ", idopertype=" + idopertype +
                ", fromdate=" + fromdate +
                ", todate=" + todate +
                ", idsysoper=" + idsysoper +
                ", idsysoperedit=" + idsysoperedit +
                "}";
    }
}
