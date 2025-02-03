package bookstore.pjgmajander.bookstore.model;

public class Book {

    // class attributes

    private String title;
    private String author;
    private int publicationYear;
    private int price;
    private String isbn;


    // 0-args-constructor

    public Book() {
    }

    // main-constructor

    public Book(String title, String author, int publicationYear, int price, String isbn) {
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.price = price;
        this.isbn = isbn;
    }

    // GET-constructors

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublicationyear() {
        return publicationYear;
    }

    public int getPrice(){
        return price;
    }

    public String getIsbn(){
        return isbn;
    }

    // SET-constructors

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublicationyear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // OVERRIDE

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", price=" + price + ", isbn=" + isbn + "]";
    }

}
