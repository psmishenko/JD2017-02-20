package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 10.03.2017.
 * Класс Шкаф реализация интерфейса Мебель
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
    public void sborka() throws MebelException {
        if (isUpakovan())
            throw new MebelException("Шкаф не распакован для сборки");
        isSobran = true;
    }

    @Override
    public void razborka() throws MebelException {
        isSobran = false;
    }

    @Override
    public void otkrytie() throws MebelException  {
        if (!isSobran())
            throw new MebelException("Шкаф не собран, открыть нельзя");
        isOtkryt = true;
    }

    @Override
    public void zakrytie() throws MebelException  {
        if (!isSobran())
            throw new MebelException("Шкаф не собран, закрыть нельзя");
        isOtkryt = false;
    }

    @Override
    public void upakovka() throws MebelException {
        if (isSobran())
            throw new MebelException("Шкаф не разобран");
        isUpakovan = true;
    }

    @Override
    public void raspakovka() throws MebelException {
        isUpakovan = false;
    }

    @Override
    public void perevozka() throws MebelException {
        zakrytie();
        razborka();
        upakovka();
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
