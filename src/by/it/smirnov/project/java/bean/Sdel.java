package by.it.smirnov.project.java.bean;

import java.sql.Date;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class Sdel extends AbstractBaseClass {
    private Bank bank;
    private double summa;
    private Valut valut;
    private OperType operType;
	private Date fromdate;
    private Date todate;
    private int idsysoper;
    private int idsysoperedit;

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
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

    public OperType getOperType() {
        return operType;
    }

    public void setOperType(OperType operType) {
        this.operType = operType;
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
        if (bank.getId() != sdel.bank.getId()) return false;
        if (Double.compare(sdel.summa, summa) != 0) return false;
        if (valut.getId() != sdel.valut.getId()) return false;
        if (operType.getId() != sdel.operType.getId()) return false;
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
        result = 31 * result + bank.getId();
        temp = Double.doubleToLongBits(summa);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + valut.getId();
        result = 31 * result + operType.getId();
        result = 31 * result + (fromdate != null ? fromdate.hashCode() : 0);
        result = 31 * result + (todate != null ? todate.hashCode() : 0);
        result = 31 * result + idsysoper;
        result = 31 * result + idsysoperedit;
        return result;
    }

    public Sdel(int id, Bank bank, double summa, Valut valut, OperType operType, Date fromdate, Date todate, int idsysoper, int idsysoperedit) {
        setId(id);
        this.bank = bank;
        this.summa = summa;
        this.valut = valut;
        this.operType = operType;
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
                ", bank=" + bank.getName() +
                ", summa=" + summa +
                ", valut=" + valut.getNamesokr() +
                ", idopertype=" + operType.getName() +
                ", fromdate=" + fromdate +
                ", todate=" + todate +
                ", idsysoper=" + idsysoper +
                ", idsysoperedit=" + idsysoperedit +
                "}";
    }
}
