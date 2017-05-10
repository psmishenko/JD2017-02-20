package by.it.zeynalov.jd03_02.homework.beans;

public class Role {

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

        Role roles = (Role) o;

        if (id != roles.id) return false;
        return title != null ? title.equals(roles.title) : roles.title == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        return result;
    }

    public Role(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public Role() {
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
