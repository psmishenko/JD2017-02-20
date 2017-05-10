package by.it.zeynalov.jd03_02.homework.beans;

public class Menu {
    private int id;
    private String title;
    private int price;
    private String recept;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public int getPrice() {return price;}

    public void setPrice(int price) {this.price = price;}

    public String getRecept() {return recept;}

    public void setRecept(String recept) {this.recept = recept;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (id != menu.id) return false;
        if (price != menu.price) return false;
        if (title != null ? !title.equals(menu.title) : menu.title != null) return false;
        return recept != null ? recept.equals(menu.recept) : menu.recept == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + price;
        result = 31 * result + (recept != null ? recept.hashCode() : 0);
        return result;
    }

    public Menu(int id, String title, int price, String recept) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.recept = recept;
    }

    public Menu() {
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", recept='" + recept + '\'' +
                '}';
    }
}
