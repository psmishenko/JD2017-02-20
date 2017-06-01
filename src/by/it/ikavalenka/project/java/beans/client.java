package by.it.ikavalenka.project.java.beans;

/**
 * Created by USER on 09.05.2017.
 */
public class client  {
    private int Client_ID;
    private int Login;
    private int Password;
    private int order_ID;
    private String cost_order;

    public int getClient_ID() {
        return Client_ID;
    }

    public void setClient_ID(int client_ID) {
        this.Client_ID = client_ID;
    }

    public int getLogin() {
        return Login;
    }

    public void setLogin(int login) {
        this.Login = login;
    }

    public int getPassword() {
        return Password;
    }

    public void setPassword(int password) {
        this.Password = password;
    }

    public int getOrder_ID() {
        return order_ID;
    }

    public void setOrder_ID(int order_ID) {
        this.order_ID = order_ID;
    }

    public String getCost_order() {
        return cost_order;
    }

    public void setCost_order(String cost_order) {
        this.cost_order = cost_order;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        client client = (by.it.ikavalenka.project.java.beans.client) obj;
        if (Client_ID != client.Client_ID) return false;
        if (Login != client.Login) return false;
        if (Password != client.Password) return false;
        if (order_ID != client.order_ID) return  false;
        return cost_order != null ? client.equals(client.cost_order):client.cost_order == null;
    }

    @Override
    public int hashCode() {
        int result = Client_ID;
        result = 31 * result + Login;
        result = 31 * result +Password;
        result = 31 * result + order_ID;
        result = 31 * result + (cost_order != null ? cost_order.hashCode() :0);
        return  result;
    }
    public client (int Client_ID, int Login, int Password, int order_ID, String cost_order){
        this.Client_ID = Client_ID;
        this.Login = Login;
        this.Password = Password;
        this.order_ID = order_ID;
        this.cost_order=cost_order;
    }
    public client(){}

    @Override
    public String toString() {
    return "client{" + "Client_ID" + Client_ID +",Login" +Login +",Password" + Password +",order_ID"+ order_ID+",cost_order"+cost_order+"}";
    }
}
