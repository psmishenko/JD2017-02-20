package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public abstract class Shkaf implements IMebel {
    private boolean isSobran;
    private boolean isOtkryt;
    private boolean isUpakovan;

    private String name;

    // Конструктор
    public Shkaf(String name) {
        this.name = name;
        isSobran = false;
        isOtkryt = false;
        isUpakovan = true;
    }

    @Override
    public void sborka() {
        isSobran = true;
    }

    @Override
    public void razborka() {
        isSobran = false;
    }

    @Override
    public void otkrytie() {
        isOtkryt = true;
    }

    @Override
    public void zakrytie() {
        isOtkryt = false;
    }

    @Override
    public void upakovka() {
        isUpakovan = true;
    }

    @Override
    public void raspakovka() {
        isUpakovan = false;
    }

    @Override
    public void perevozka() {
        isOtkryt = false;
        isSobran = false;
        isUpakovan = true;
    }

    public String getName() {
        return name;
    }

    public boolean isSobran() {
        return isSobran;
    }

    public boolean isOtkryt() {
        return isOtkryt;
    }

    public boolean isUpakovan() {
        return isUpakovan;
    }

    public abstract void showState();
}
