package by.it.smirnov.jd01_12;

/**
 * Created by aleksey.smirnov on 20.03.2017.
 */
public class Runner {
    public static void main(String[] args) {

        System.out.println("{--------------------}\nA1:");
        TaskA.runA1();
        System.out.println("{--------------------}");
        System.out.println("Объединение множеств");
        TaskA.runA2();
        System.out.println("{--------------------}");
        System.out.println("Пересечение множеств");
        TaskA.runA2_1();
        System.out.println("{--------------------}");
        System.out.println("Отрицательные элементы в конец");
        TaskA.runA3();

        System.out.println("{--------------------}");
        System.out.println("Частота встречаемости слов:");
        TaskB.runB1();
        System.out.println("{--------------------}");
        System.out.println("Считалочка:");
        TaskB.runB2(20000);
        System.out.println("Считалочка с новым итератором:");
        TaskB taskB = new TaskB();
        taskB.runB2NewIterator(20000);


        System.out.println("{--------------------}");
        System.out.println("Работа со списком:");
        TaskC1 task = new TaskC1();
        task.add("Хлеб", 12345);
        task.add("Хлеб", 54321);
        task.add("Хлеб", 22222);
        task.add("Хлеб", 11553);
        task.add("Хлеб", 1);
        task.add("Батон", 15);
        task.add("Сушки", 29);
        task.add("Сушки", 20);
        System.out.println("Список, отсортированный по возрастанию шифров:");
        task.printList();
        System.out.println("Список без дублирующих наименований объектов (шифр - первый попавшийся):");
        task.printListUniqueName();
        System.out.println("{--------------------}");
        System.out.println("Объединение множеств Integer");
        TaskC.runC2UnionInteger();
        System.out.println("Объединение множеств Double");
        TaskC.runC2UnionDouble();
        System.out.println("{--------------------}");
        System.out.println("Пересечение множеств Integer");
        TaskC.runC2CrossInteger();
        System.out.println("Пересечение множеств Double");
        TaskC.runC2CrossDouble();
        System.out.println("{--------------------}");
        System.out.println("Проверка формулы на скобки:");
        System.out.println(TaskC.checkStr("1+2") ? "Верная строка" : "Неверная строка");
        System.out.println(TaskC.checkStr("(1+2*(1+{1,2,3}))") ? "Верная строка" : "Неверная строка");
        System.out.println(TaskC.checkStr("(1+2*(1+{1,2,3))") ? "Верная строка" : "Неверная строка");
        System.out.println(TaskC.checkStr("((1+2*(1+{1,2,3}))") ? "Верная строка" : "Неверная строка");


    }
}
