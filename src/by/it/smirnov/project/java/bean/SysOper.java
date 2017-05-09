package by.it.smirnov.project.java.bean;

import java.sql.Timestamp;

/**
 * Created by aleksey.smirnov on 01.05.2017.
 */
public class SysOper extends AbstractBaseClass {
    private int iduser;
    private Timestamp datetime;

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SysOper sysOper = (SysOper) o;

        if (getId() != sysOper.getId()) return false;
        if (iduser != sysOper.iduser) return false;
        return datetime != null ? datetime.equals(sysOper.datetime) : sysOper.datetime == null;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + iduser;
        result = 31 * result + (datetime != null ? datetime.hashCode() : 0);
        return result;
    }

    public SysOper(int id, int iduser, Timestamp datetime) {
        setId(id);
        this.iduser = iduser;
        this.datetime = datetime;
    }

    public SysOper() {
    }

    @Override
    public String toString() {
        return "SysOper{" +
                "id=" + getId() +
                ", iduser=" + iduser +
                ", datetime=" + datetime +
                "}";
    }
}
