package by.it.radivonik.jd01_08;

/**
 * Created by Radivonik on 10.03.2017.
 */
public class Runner {
    public static void main(String[] args) {
        Shkaf s = new BookShkaf("Книжный шкаф в зале");

        System.out.println("Задание к занятию JD01_08");
        System.out.println("Распаковка");
        s.raspakovka();
        s.showState();
        System.out.println("Сборка");
        s.sborka();
        s.showState();
        System.out.println("Открытие");
        s.otkrytie();
        s.showState();
        System.out.println("Расстановка книг");
        ((BookShkaf)s).bookFill();
        s.showState();
        System.out.println("Закрытие");
        s.zakrytie();
        s.showState();
        System.out.println("Перевозка");
        s.perevozka();
    }
}
