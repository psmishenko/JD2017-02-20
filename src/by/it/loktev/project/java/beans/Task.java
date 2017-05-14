package by.it.loktev.project.java.beans;

import by.it.loktev.project.java.controller.Log;
import by.it.loktev.project.java.dao.DAO;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class Task {

    static private SimpleDateFormat displayDateFormat=new SimpleDateFormat("dd.MM.yyyy");
    static private SimpleDateFormat htmlDateFormat=new SimpleDateFormat("yyyy-MM-dd");

    private int id;
    private String name;
    private Date endDate;
    private double price;
    private int statusId;
    private int execUserId;

    public Task() {
    }

    public Task(int id, String name, Date endDate, double price, int statusId, int execUserId) {
        this.id = id;
        this.name = name;
        this.endDate = endDate;
        this.price = price;
        this.statusId = statusId;
        this.execUserId=execUserId;
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
        return displayDateFormat.format(endDate);
    }

    public String getHtmlEndDate() {
        if ( endDate==null )
            return "";
        return htmlDateFormat.format(endDate);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHtmlPrice() {
        return String.format("%10.2f",price).trim().replace(",",".");
    }

    public String getFormattedPrice() {
        return String.format("%10.2f",price).trim().replace(",",".");
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName(){
        DAO dao=DAO.getInstance();
        Status status=dao.getStatus().getById(statusId);
        return status.getName();
    }

    public String getExecUserName(){
        if ( statusId==1 )
            return "";
        DAO dao=DAO.getInstance();
        User user=dao.getUser().getById(execUserId);
        return user.getLogin();
    }

    public int getExecUserId() {
        return execUserId;
    }

    public void setExecUserId(int execUserId) {
        this.execUserId = execUserId;
    }

    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", name=" + name +
                ", endDate=" + endDate +
                ", price=" + price +
                ", statusId=" + statusId +
                ", execUserId=" + execUserId +
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
        if (execUserId != task.execUserId) return false;
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
        result = 31 * result + execUserId;
        return result;
    }
}
