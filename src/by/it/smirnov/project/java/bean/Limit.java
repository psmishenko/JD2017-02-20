package by.it.smirnov.project.java.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Limit extends AbstractBaseClass {
    private GroupBank groupbank;
	private Date fromdate;
    private OperType opertype;
    private double summa;
    private Valut valut;
    private int idsysoper;

    public GroupBank getGroupbank() {
        return groupbank;
    }

    public void setGroupbank(GroupBank groupbank) {
        this.groupbank = groupbank;
    }

    public Date getFromdate() {
        return fromdate;
    }

    public void setFromdate(Date fromdate) {
        this.fromdate = fromdate;
    }

    public OperType getOpertype() {
        return opertype;
    }

    public void setOpertype(OperType opertype) {
        this.opertype = opertype;
    }

    public double getSumma() {
        return summa;
    }

    public void setSumma(double summa) {
        this.summa = summa;
    }

    public Valut getValut() {
        return valut;
    }

    public void setValut(Valut valut) {
        this.valut = valut;
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
        if (groupbank.getId() != limit.groupbank.getId()) return false;
        if (opertype.getId() != limit.opertype.getId()) return false;
        if (Double.compare(limit.summa, summa) != 0) return false;
        if (valut.getId() != limit.valut.getId()) return false;
        if (idsysoper != limit.idsysoper) return false;
        return fromdate != null ? fromdate.equals(limit.fromdate) : limit.fromdate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + groupbank.getId();
        result = 31 * result + (fromdate != null ? fromdate.hashCode() : 0);
        result = 31 * result + opertype.getId();
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + valut.getId();
        result = 31 * result + idsysoper;
        return result;
    }

    public Limit(int id, GroupBank groupbank, Date fromdate, OperType opertype, double summa, Valut valut, int idsysoper) {
        setId(id);
        this.groupbank = groupbank;
        this.fromdate = fromdate;
        this.opertype = opertype;
        this.summa = summa;
        this.valut = valut;
        this.idsysoper = idsysoper;
    }

    public Limit() {
    }

    @Override
    public String toString() {
        return "Limit{" +
                "id=" + getId() +
                ", groupbank=" + groupbank.getName() +
                ", fromdate=" + fromdate +
                ", opertype=" + opertype.getName() +
                ", summa=" + summa +
                ", valut=" + valut.getNamesokr() +
                ", idsysoper=" + idsysoper +
                "}";
    }
}
