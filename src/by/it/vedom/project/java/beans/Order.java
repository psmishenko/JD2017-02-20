package by.it.vedom.project.java.beans;

public class Order {
    private int id;
    private int fk_user;
    private int fk_product;

    public Order() {
    }

    public Order(int id, int fk_user, int fk_product) {
        this.id = id;
        this.fk_user = fk_user;
        this.fk_product = fk_product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public int getFk_product() {
        return fk_product;
    }

    public void setFk_product(int fk_product) {
        this.fk_product = fk_product;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (fk_user != order.fk_user) return false;
        return fk_product == order.fk_product;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fk_user;
        result = 31 * result + fk_product;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", fk_user=" + fk_user +
                ", fk_product=" + fk_product +
                '}';
    }
}
