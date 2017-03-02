package by.it.vedom.jd01_05;

/**
 * Created by Владислав on 01.03.2017.
 */
public class Runner {

    public static void main(String[] args) {

        System.out.println("┏━━━━━━━━━━━━━━┓");
        System.out.println("┃ Вариант 16 ┃");
        System.out.println("┗━━━━━━━━━━━━━━┛");
//        // Задача 1
//        double x = 234.1;
//        System.out.println("Задача №1");
//        System.out.println(Task1.optionA(x));
//        System.out.println(Task1.optionB(x));
//        System.out.println();
//
//        //Задача 2
//        System.out.println("Задача №2");
//        System.out.println(Task2.calculate((0.94 * pow(10, -3)), 10.093 ));
//        System.out.println();
//
//        //Задача 3
//        System.out.println("Задача №3");
//        Task3.printTable();
//        System.out.println();
//
//        //Задача 4
//        System.out.println("Задача №4");
//        System.out.println(Task4.calculate());
//        System.out.println();
//
//        //Задача 5
//        System.out.println("Задача №5");
//        Task5.calculate();
//        System.out.println();

        //Задача 6
        System.out.println("Задача №6");
        double[] a = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "Исходный");
        double sumArrayA = Task6.getSumElementsMoreThanThree(a);
        System.out.println("Сумма элементов исходного массива, которые больше 3 = " + sumArrayA+ "\n");
        double[] b = Task6.getElementsMoreThanThree(a);
        task6.printArray(b, "Сформированный");
    }
}
