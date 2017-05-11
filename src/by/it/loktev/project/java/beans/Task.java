package by.it.loktev.project.java.beans;

import java.util.Date;

public class Task {

    private int id;
    private String name;
    private Date endDate;
    private double price;
    private int statusId;

    public Task() {
    }

    public Task(int id, String name, Date endDate, double price, int statusId) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.price = price;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int stateId) {
        this.statusId = stateId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name=" + name +
                ", endDate=" + endDate.toString() +
                ", price=" + price +
                ", statusId=" + statusId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (id != task.id) return false;
        if (Double.compare(task.price, price) != 0) return false;
        if (statusId != task.statusId) return false;
        if (name != null ? !name.equals(task.name) : task.name != null) return false;
        return endDate != null ? endDate.equals(task.endDate) : task.endDate == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + statusId;
        return result;
    }
}
