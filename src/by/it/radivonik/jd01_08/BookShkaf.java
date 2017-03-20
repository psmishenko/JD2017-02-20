package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public class BookShkaf extends Shkaf {
    private boolean isBookFill;

    public BookShkaf(String name) {
        super(name);
        isBookFill = false;
    }

    @Override
    public void sborka() {
        super.sborka();
        isBookFill = false;
    }

    @Override
    public void razborka() {
        super.razborka();
        isBookFill = false;
    }

    @Override
    public void upakovka() {
        super.upakovka();
        isBookFill = false;
    }

    @Override
    public void raspakovka() {
        super.raspakovka();
        isBookFill = false;
    }

    @Override
    public void perevozka() {
        super.perevozka();
        isBookFill = false;
    }

    @Override
    public void showState() {
        System.out.printf(this.toString());
    }

    @Override
    public String toString() {
        String sUpakovan = this.isUpakovan() ? "Упакован" : "Распакован";
        String sSobran = this.isSobran() ? "Собран" : "Разобран";
        String sOtkryt = this.isOtkryt() ? "Открыт" : "Закрыт";
        String sBookFill = this.isBookFill ? "Книги есть" : "Книг нет";
        return String.format("%s: %s %s %s %s\n",getName(),sUpakovan,sSobran,sOtkryt,sBookFill);
    }

    public void bookFill () {
        isBookFill = true;
    }
        
    public boolean isBookFill() {
        return isBookFill;
    }
}
