package by.it.loktev.project.java.beans;

import by.it.loktev.project.java.dao.DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Task {

    static SimpleDateFormat dateFormat=new SimpleDateFormat("dd.MM.yyyy");

    static Map<Integer,Status> statusesMap;

    static {
        DAO dao=DAO.getInstance();
        statusesMap=dao.getStatus().getMap();
    }

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

    public String getFormattedEndDate() {
        if ( endDate==null )
            return "";
        return dateFormat.format(endDate);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getFormattedPrice() {
        return String.format("%10.2f",price);
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName(){
        Status status=statusesMap.get(statusId);
        return status.getName();
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name=" + name +
                ", endDate=" + endDate +
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
