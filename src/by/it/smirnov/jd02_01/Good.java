package by.it.smirnov.jd02_01;

/**
 * Класс товара
 */
public class Good {
    private String name; // наименование
    private double price; // цена

    public Good(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

}