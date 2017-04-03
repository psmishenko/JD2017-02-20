package by.it.smirnov.jd01_13;

/**
 * Created by aleksey.smirnov on 22.03.2017.
 */
public class TaskB {
    /**
     * Класс, в котором 3 void процедуры, вложенные друг в друга.
     *  Каждую процедуру сопровождена двумя сообщениями: в начале и в конце тела процедуры.
     * Код процедуры – произвольный, но с возможным делением на ноль (3 уровень),
     * извлечением корня из отрицательного числа (2-й уровень), другими ошибками (1-й и 0-й
     * уровни, где 0-й уровень это public static void main(String[ ] args) ).
     *  Один тип ошибки – деление на ноль обрабатывать в процедуре, остальные ошибки
     * пробрасываются и обрабатываются в main.
     * @version 1.0.0
     */
    public static void main(String[] args) {
        try {
            level1();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Процедура первого уровня
     * @version 1.0.0
     */
    private static void level1() {
        System.out.println("Начало процедуры level1");
        level2();
        String s = "123";
        if (Math.random()<0.5)
            s = "qwerty";
        System.out.println(Double.parseDouble(s));
        System.out.println("Окончание процедуры level1");
    }
    /**
     * Процедура второго уровня
     * @version 1.0.0
     */
    private static void level2() {
        System.out.println("Начало процедуры level2");
        level3();
        if (Math.random()<0.5)
            throw new ArithmeticException("Генерация исключения");
        System.out.println("Окончание процедуры level2");
    }
    /**
     * Процедура третьего уровня
     * @version 1.0.0
     */
    private static void level3() {
        System.out.println("Начало процедуры level3");
        try {
            int i = 3/((int)(Math.random()*4));
        } catch (ArithmeticException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        System.out.println("Окончание процедуры level3");

    }
}
