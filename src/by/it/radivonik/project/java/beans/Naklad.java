package by.it.radivonik.project.java.beans;

import java.sql.Date;

/**
 * Created by Radivonik on 03.05.2017.
 */
public class Naklad {
    private int id;
    private Date date;
    private String num;
    private String seria;
    private User user;
    private TypeNaklad type;
    private Klient klient;
    private Avto avto;

    public Naklad() {
    }

    public Naklad(int id, Date date, String num, String seria, User user, TypeNaklad type, Klient klient, Avto avto) {
        this.id = id;
        this.date = date;
        this.num = num;
        this.seria = seria;
        this.user = user;
        this.type = type;
        this.klient = klient;
        this.avto = avto;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TypeNaklad getType() {
        return type;
    }

    public void setType(TypeNaklad type) {
        this.type = type;
    }

    public Klient getKlient() {
        return klient;
    }

    public void setKlient(Klient idKlient) {
        this.klient = klient;
    }

    public Avto getAvto() {
        return avto;
    }

    public void setAvto(Avto avto) {
        this.avto = avto;
    }

    @Override
    public String toString() {
        return
            "Naklad{id=" + id + ", date=" + date + ", num='" + num + "', seria='" + seria + "', " +
            "user=" + user + ", type=" + type + ", klient=" + klient + ", avto=" + avto + "}";
    }
}
