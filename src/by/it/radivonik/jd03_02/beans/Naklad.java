package by.it.radivonik.jd03_02.beans;

import java.sql.Date;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class Naklad {
    private int id;
    private Date date;
    private String num;
    private String seria;
    private int idUser;
    private int idType;
    private int idKlient;
    private int idAvto;

    public Naklad() {
    }

    public Naklad(int id, Date date, String num, String seria, int idUser, int idType, int idKlient, int idAvto) {
        this.id = id;
        this.date = date;
        this.num = num;
        this.seria = seria;
        this.idUser = idUser;
        this.idType = idType;
        this.idKlient = idKlient;
        this.idAvto = idAvto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getSeria() {
        return seria;
    }

    public void setSeria(String seria) {
        this.seria = seria;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdKlient() {
        return idKlient;
    }

    public void setIdKlient(int idKlient) {
        this.idKlient = idKlient;
    }

    public int getIdAvto() {
        return idAvto;
    }

    public void setIdAvto(int idAvto) {
        this.idAvto = idAvto;
    }

    @Override
    public String toString() {
        return
            "Naklad{id=" + id + ", date=" + date + ", num='" + num + "', seria='" + seria + "', " +
            "idUser=" + idUser + ", idType=" + idType + ", idKlient=" + idKlient + ", idAvto=" + idAvto + "}";
    }
}
