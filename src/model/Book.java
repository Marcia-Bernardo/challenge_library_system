package model;

import java.time.LocalDateTime;

public class Book {
    private static int autoID;
    private int id;
    private String name;
    private String author;
    private int year;
    private String edition;
    private int quantity;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;

    public Book(String name, LocalDateTime createAt, int quantity, String edition, int year, String author) {
        autoID++;
        this.id=autoID;
        this.name = name;
        this.createAt = createAt;
        this.updateAt = createAt;
        this.quantity = quantity;
        this.edition = edition;
        this.year = year;
        this.author = author;
    }

    public Book(String name, int quantity, String edition, int year, String author) {
        autoID++;
        this.id=autoID;
        this.name = name;
        this.createAt = LocalDateTime.now();
        this.updateAt = LocalDateTime.now();
        this.quantity = quantity;
        this.edition = edition;
        this.year = year;
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", edition='" + edition + '\'' +
                ", quantity=" + quantity +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                '}';
    }

    public String toStringLoan() {
        return "{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", edition='" + edition + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Book book = (Book) o;
        return year == book.year && quantity == book.quantity && name.equals(book.name) && author.equals(book.author) && edition.equals(book.edition) && createAt.equals(book.createAt) && updateAt.equals(book.updateAt);
    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + author.hashCode();
        result = 31 * result + year;
        result = 31 * result + edition.hashCode();
        result = 31 * result + quantity;
        result = 31 * result + createAt.hashCode();
        result = 31 * result + updateAt.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }


}
