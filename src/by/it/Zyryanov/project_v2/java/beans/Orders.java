package by.it.Zyryanov.project_v2.java.beans;


public class Orders {


    private int id;
    private int fk_Users;
    private int fk_Books;


    public Orders() {
    }


    public Orders(int id, int fk_Users, int fk_Books) {
        this.id = id;
        this.fk_Users = fk_Users;
        this.fk_Books = fk_Books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orders orders = (Orders) o;

        if (id != orders.id) return false;
        if (fk_Users != orders.fk_Users) return false;
        return fk_Books == orders.fk_Books;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + fk_Users;
        result = 31 * result + fk_Books;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFk_Users() {
        return fk_Users;
    }

    public void setFk_Users(int fk_Users) {
        this.fk_Users = fk_Users;
    }

    public int getFk_Books() {
        return fk_Books;
    }

    public void setFk_Books(int fk_Books) {
        this.fk_Books = fk_Books;
    }


    @Override
    public String toString() {
        return "Orders{" +
                "id=" + id +
                ", fk_Users=" + fk_Users +
                ", fk_Books=" + fk_Books +
                '}';
    }
}
