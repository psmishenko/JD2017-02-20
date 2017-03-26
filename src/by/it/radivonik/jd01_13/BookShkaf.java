package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 10.03.2017.
 * Класс Книжный шкаф
 */
public class BookShkaf extends Shkaf {
    private boolean isBookFill;

    public BookShkaf(String name) {
        super(name);
        isBookFill = false;
    }

    @Override
    public void razborka() throws MebelException {
        if (isBookFill())
            throw new MebelException("Шкаф заполнен книгами, разбирать нельзя");
        super.razborka();
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

    public void bookFill () throws MebelException {
        if (!isSobran())
            throw new MebelException("Шкаф не собран");
        isBookFill = true;
    }

    public void bookFree () {
        isBookFill = false;
    }

    public boolean isBookFill() {
        return isBookFill;
    }
}
