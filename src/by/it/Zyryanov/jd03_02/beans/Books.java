package by.it.Zyryanov.jd03_02.beans;

/**
 * Created by georgijzyranov on 04.05.17.
 */
public class Books {

    private int id;
    private String booktitle;
    private String description;
    private String author;
    private int price;


    public Books() {
    }

    public Books(int id, String booktitle, String description, String author, int price) {
        this.id = id;
        this.booktitle = booktitle;
        this.description = description;
        this.author = author;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Books books = (Books) o;

        if (id != books.id) return false;
        if (price != books.price) return false;
        if (booktitle != null ? !booktitle.equals(books.booktitle) : books.booktitle != null) return false;
        if (description != null ? !description.equals(books.description) : books.description != null) return false;
        return author != null ? author.equals(books.author) : books.author == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (booktitle != null ? booktitle.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + price;
        return result;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBooktitle() {
        return booktitle;
    }

    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", booktitle='" + booktitle + '\'' +
                ", description='" + description + '\'' +
                ", author='" + author + '\'' +
                ", price=" + price +
                '}';
    }
}
