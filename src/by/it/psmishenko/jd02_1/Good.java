package by.it.psmishenko.jd02_1;

/**
 * Created by user on 29.03.2017.
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

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return name+"( Цена: "+getPrice()+" рублей )";
    }
}
