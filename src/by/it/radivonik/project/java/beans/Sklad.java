package by.it.radivonik.project.java.beans;

import java.math.BigDecimal;
import java.math.MathContext;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class Sklad {
    private int id;
    private BigDecimal count;
    private BigDecimal cena;
    private Tovar tovar;
    private User user;
    private BigDecimal stoim;

    public Sklad() {
    }

    public Sklad(int id, BigDecimal count, BigDecimal cena, Tovar tovar, User user) {
        this.id = id;
        this.count = count;
        this.cena = cena;
        this.tovar = tovar;
        this.user = user;
        this.stoim = count.multiply(cena).round(new MathContext(2));
    }

    public Sklad(int id, BigDecimal count, BigDecimal cena, Tovar tovar, User user, BigDecimal stoim) {
        this.id = id;
        this.count = count;
        this.cena = cena;
        this.tovar = tovar;
        this.user = user;
        this.stoim = stoim;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Tovar getTovar() {
        return tovar;
    }

    public void setTovar(Tovar tovar) {
        this.tovar = tovar;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getStoim() {
        return stoim;
    }

    public void setStoim(BigDecimal stoim) {
        this.stoim = stoim;
    }

    @Override
    public String toString() {
        return
            "Sklad{id=" + id + ", count=" + count + ", cena=" + cena + ", " +
            "tovar=" + tovar.toString() + ", user=" + user.toString() + "}";
    }
}
