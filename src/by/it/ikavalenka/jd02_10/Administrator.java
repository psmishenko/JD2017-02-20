package by.it.ikavalenka.jd02_10;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by USER on 23.04.2017.
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Administrator",propOrder ={
        "Catalog",
        "Order",
        "BlackList"} )
public class Administrator {
    @XmlAttribute(required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlElement(required = true)
    @XmlID
    private String login;
    @XmlElement(required = true)
    protected String Catalog;
    @XmlElement(required = true)
    protected Integer Order;
    @XmlElement(required = true)
    protected String BlackList;


    private Client client = new Client();
    private OrderC orderC = new OrderC();
    private BlackListStatus blackListStatus = new BlackListStatus();

    public Administrator(String zAds36, String catalogAll, int i, String none, String s, int i1, String normal, int i2, String single, String none1) {}
    public Administrator(String login, String Catalog, int Order, String BlackList, Client client, OrderC orderC, BlackListStatus blackListStatus) {
        this.login = login;
        this.Catalog = Catalog;
        this.Order = Order;
        this.BlackList = BlackList;
        this.client = client;
        this.orderC = orderC;
        this.blackListStatus = blackListStatus;

    }

    public String getLogin() {
        return login;
    }

    public String getCatalog() {
        return Catalog;
    }

    public Integer getOrder() {
        return Order;
    }

    public String getBlackList() {
        return BlackList;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setCatalog(String catalog) {
        Catalog = catalog;
    }

    public void setOrder(Integer order) {
        Order = order;
    }

    public void setBlackList(String blackList) {
        BlackList = blackList;
    }

    public String toString() {
        return "\nLogin: " + login + "\nCatalog:" + Catalog + "\nOrder:" + Order + "\nBlackList:" + BlackList.toString();
    }

    @XmlRootElement
    @XmlType(name = "Client",propOrder ={
            "MadeOrder",
            "PayOreder"})
    public static class Client {
        private String MadeOrder;
        private Integer PayOreder;

        public Client() {
        }

        public Client(String MadeOrder, int PayOrder) {
            this.MadeOrder = MadeOrder;
            this.PayOreder = PayOrder;
        }

        public String getMadeOrder() {
            return MadeOrder;
        }

        public void setMadeOrder(String madeOrder) {
            this.MadeOrder = madeOrder;
        }

        public Integer getPayOreder() {
            return PayOreder;
        }

        public void setPayOreder(Integer payOreder) {
            this.PayOreder = payOreder;
        }
        public String toString() {
            return "\nMadeOrder: " + MadeOrder + "\nPayOreder:" + PayOreder.toString();
        }
    }

    @XmlRootElement
    @XmlType(name = "OrderC",propOrder ={
            "Profit",
            "Count",
            "Sale"})
    public static class OrderC{
        private String Profit;
        private String Count;
        private String Sale;
        public OrderC(){}
        public  OrderC(String Profit, String Count, String Sale){
            this.Profit = Profit;
            this.Count = Count;
            this.Sale = Sale;
        }

        public String getProfit() {
            return Profit;
        }

        public String getCount() {
            return Count;
        }

        public String getSale() {
            return Sale;
        }

        public void setProfit(String profit) {
            this.Profit = profit;
        }

        public void setCount(String count) {
            this.Count = count;
        }

        public void setSale(String sale) {
            this.Sale = sale;
        }
        public String toString() {
            return "\nProfit" + Profit +"\nCount" + Count + "\nSale" + Sale.toString();
         }
    }
    @XmlRootElement
    @XmlType(name = "BlackListStatus",propOrder ={
            "Client_id"})
    public static  class  BlackListStatus {
        private String Client_id;
        public BlackListStatus(){}

    public void BlackListStatus(String Client_id) {
        this.Client_id = Client_id;
    }

        public String  getClient_id() {
            return Client_id;
        }

        public void setClient_id(String client_id) {
            Client_id = client_id;
        }
        public String toString() {
            return "\nClient_id" + Client_id.toString();
        }
    }

}

