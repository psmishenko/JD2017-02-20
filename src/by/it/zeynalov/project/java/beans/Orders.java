package by.it.zeynalov.project.java.beans;

public class Orders {

    private int ID;
    private String Latte;
    private String Americano;
    private String Cappuccino;
    private String Espresso;

    public Orders() {
    }

    public Orders(int ID, String latte, String americano, String cappuccino, String espresso) {
        this.ID = ID;
        Latte = latte;
        Americano = americano;
        Cappuccino = cappuccino;
        Espresso = espresso;
    }

    public int getID() {return ID;}

    public void setID(int ID) {this.ID = ID;}

    public String getLatte() {return Latte;}

    public void setLatte(String latte) {Latte = latte;}

    public String getAmericano() {return Americano;}

    public void setAmericano(String americano) {Americano = americano;}

    public String getCappuccino() {return Cappuccino;}

    public void setCappuccino(String cappuccino) {Cappuccino = cappuccino;}

    public String getEspresso() {return Espresso;}

    public void setEspresso(String espresso) {Espresso = espresso;}

    @Override
    public String toString() {
        return "Orders{" +
                "ID=" + ID +
                ", Latte='" + Latte + '\'' +
                ", Americano='" + Americano + '\'' +
                ", Cappuccino='" + Cappuccino + '\'' +
                ", Espresso='" + Espresso + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (ID != orders.ID) return false;
        if (Latte != null ? !Latte.equals(orders.Latte) : orders.Latte != null) return false;
        if (Americano != null ? !Americano.equals(orders.Americano) : orders.Americano != null) return false;
        if (Cappuccino != null ? !Cappuccino.equals(orders.Cappuccino) : orders.Cappuccino != null) return false;
        return Espresso != null ? Espresso.equals(orders.Espresso) : orders.Espresso == null;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + (Latte != null ? Latte.hashCode() : 0);
        result = 31 * result + (Americano != null ? Americano.hashCode() : 0);
        result = 31 * result + (Cappuccino != null ? Cappuccino.hashCode() : 0);
        result = 31 * result + (Espresso != null ? Espresso.hashCode() : 0);
        return result;
    }
}
