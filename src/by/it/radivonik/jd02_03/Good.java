package by.it.radivonik.jd02_03;

/**
 * Created by Radivonik on 31.03.2017.
 * Класс, определяющий продукт (наименованиет и цена)
 */
public class Good {
    private String name;
    private double price;

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
