package by.it.psmishenko.jd03_2.beans;

/**
 * Created by user on 29.04.2017.
 */
public class Book {
    private int id;
    private String author;
    private String title;
    private int year;
    private String isbn;
    private int lid;
    private int fk_users;

    public Book() {
    }

    public Book(int id, String author, String title, int year, String isbn, int lid, int fk_users) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.year = year;
        this.isbn = isbn;
        this.lid = lid;
        this.fk_users = fk_users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getLid() {
        return lid;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getFk_users() {
        return fk_users;
    }

    public void setFk_users(int fk_users) {
        this.fk_users = fk_users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;

        if (id != book.id) return false;
        if (year != book.year) return false;
        if (lid != book.lid) return false;
        if (fk_users != book.fk_users) return false;
        if (author != null ? !author.equals(book.author) : book.author != null) return false;
        if (title != null ? !title.equals(book.title) : book.title != null) return false;
        return isbn != null ? isbn.equals(book.isbn) : book.isbn == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (author != null ? author.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (isbn != null ? isbn.hashCode() : 0);
        result = 31 * result + lid;
        result = 31 * result + fk_users;
        return result;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", year=" + year +
                ", isbn='" + isbn + '\'' +
                ", lid=" + lid +
                ", fk_users=" + fk_users +
                '}';
    }
}
