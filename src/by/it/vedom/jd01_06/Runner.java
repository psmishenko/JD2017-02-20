package by.it.vedom.jd01_06;

public class Runner {

    public static void main(String[] args) {

        //Задание А
        System.out.println("----------------------");
        System.out.println("Задание А");
        System.out.println("----------------------");
        TaskA.optionA();
        System.out.println();

        //Задание B
        System.out.println("----------------------");
        System.out.println("Задание B");
        System.out.println("----------------------");
        System.out.println("Количество слов, у которых первая и последняя буквы гласные: " + TaskB.optionB1());
        System.out.println();
        TaskB.optionB2();
    }

}
