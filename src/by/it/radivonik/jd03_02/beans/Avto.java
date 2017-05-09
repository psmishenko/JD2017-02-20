package by.it.radivonik.jd03_02.beans;

/**
 * Created by Radivonik on 04.05.2017.
 */
public class Avto {
    private int id;
    private String numgos;
    private String voditel;

    public Avto() {
    }

    public Avto(int id, String numgos, String voditel) {
        this.id = id;
        this.numgos = numgos;
        this.voditel = voditel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumgos() {
        return numgos;
    }

    public void setNumgos(String numgos) {
        this.numgos = numgos;
    }

    public String getVoditel() {
        return voditel;
    }

    public void setVoditel(String voditel) {
        this.voditel = voditel;
    }

    @Override
    public String toString() {
        return "Avto{id=" + id + ", numgos='" + numgos + "', voditel='" + voditel + "'}";
    }
}
