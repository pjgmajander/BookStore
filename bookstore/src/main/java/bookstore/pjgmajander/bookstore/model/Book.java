package bookstore.pjgmajander.bookstore.model;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;

    // class attributes

    private String title;
    private String author;
    private Integer publicationYear;
    private BigDecimal price;
    private String isbn;

    // 0-args-constructor

    public Book() {
    }

    // main-constructor

    public Book(String title, String author, Integer publicationYear, BigDecimal price, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.isbn = isbn;
    }

    // GET-constructors

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getPublicationYear() {
        return publicationYear;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getIsbn() {
        return isbn;
    }

    // SET-constructors

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationYear(Integer publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // OVERRIDE

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", price="
                + price + ", isbn=" + isbn + "]";
    }

}
