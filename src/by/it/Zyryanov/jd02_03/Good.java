package by.it.Zyryanov.jd02_03;

/**
 * Created by georgijzyranov on 01.04.17.
 */
public class Good {
    private String name;
    private double price;


    @Override
    public String toString() {
        return "Товар " + name + " с ценой " + price + " рублей.";
    }


    Good(String name, double price) {
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
