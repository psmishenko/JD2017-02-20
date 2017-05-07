package by.it.prigozhanov.project.java.beans;

/**
 * Created by v-omf on 5/6/2017!
 */
public class Order {
    private int id;
    private String passportData;
    private String cardNumber;
    private int orderDuration;
    private String telephone;
    private int fk_Users;
    private int fk_Cars;

    public Order(int id, String passportData, String cardNumber, int orderDuration, String telephone, int fk_Users, int fk_Cars) {
        this.id = id;
        this.passportData = passportData;
        this.cardNumber = cardNumber;
        this.orderDuration = orderDuration;
        this.telephone = telephone;
        this.fk_Users = fk_Users;
        this.fk_Cars = fk_Cars;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassportData() {
        return passportData;
    }

    public void setPassportData(String passportData) {
        this.passportData = passportData;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getOrderDuration() {
        return orderDuration;
    }

    public void setOrderDuration(int orderDuration) {
        this.orderDuration = orderDuration;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getFk_Users() {
        return fk_Users;
    }

    public void setFk_Users(int fk_Users) {
        this.fk_Users = fk_Users;
    }

    public int getFk_Cars() {
        return fk_Cars;
    }

    public void setFk_Cars(int fk_Cars) {
        this.fk_Cars = fk_Cars;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (id != order.id) return false;
        if (orderDuration != order.orderDuration) return false;
        if (fk_Users != order.fk_Users) return false;
        if (fk_Cars != order.fk_Cars) return false;
        if (passportData != null ? !passportData.equals(order.passportData) : order.passportData != null) return false;
        if (cardNumber != null ? !cardNumber.equals(order.cardNumber) : order.cardNumber != null) return false;
        return telephone != null ? telephone.equals(order.telephone) : order.telephone == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (passportData != null ? passportData.hashCode() : 0);
        result = 31 * result + (cardNumber != null ? cardNumber.hashCode() : 0);
        result = 31 * result + orderDuration;
        result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
        result = 31 * result + fk_Users;
        result = 31 * result + fk_Cars;
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", passportData='" + passportData + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", orderDuration=" + orderDuration +
                ", telephone='" + telephone + '\'' +
                ", fk_Users=" + fk_Users +
                ", fk_Cars=" + fk_Cars +
                '}';
    }
}
