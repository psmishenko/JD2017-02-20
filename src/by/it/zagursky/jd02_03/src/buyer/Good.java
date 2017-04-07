package by.it.zagursky.jd02_03.src.buyer;

/**
 * Created by dzenyaa on 29.03.2017.
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

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
