package by.it.radivonik.jd01_13;

/**
 * Created by Radivonik on 26.03.2017.
 * Класс, реализующий задания Варианта C
 */
public class TaskC {
    public static void run() {
        Shkaf s = new BookShkaf("Книжный шкаф в зале");

        try {
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
            ((BookShkaf) s).bookFill();
            s.showState();
            System.out.println("Закрытие");
            s.zakrytie();
            s.showState();
            System.out.println("Перевозка");
            s.perevozka();
        }
        catch (MebelException e) {
            System.out.printf("Мебельная ошибка: %s\n", e.getMessage());
            StackTraceElement[] eSt = e.getStackTrace();
            System.out.printf("Стек ошибок:\n");
            for (StackTraceElement el : eSt) {
                System.out.printf(
                        "Ошибка произошла: в классе '%s', в файле '%s', в методе '%s', в строке '%d'\n",
                        el.getClassName(), el.getFileName(), el.getMethodName(), el.getLineNumber());
            }

        }
    }
}
