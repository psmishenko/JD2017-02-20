package by.it.zeynalov.project.java.beans;

public class Roles {

    private int id;
    private String title;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Roles roles = (Roles) o;

        if (id != roles.id) return false;
        return title != null ? title.equals(roles.title) : roles.title == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Roles(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Roles() {
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
