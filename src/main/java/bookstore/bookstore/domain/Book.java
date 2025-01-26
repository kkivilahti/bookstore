package bookstore.bookstore.domain;

public class Book {
    private String title;
    private String author;
    private int publicationYear;
    private long isbn;
    private double price;

    public Book(String author, long isbn, double price, int publicationYear, String title) {
        this.author = author;
        this.isbn = isbn;
        this.price = price;
        this.publicationYear = publicationYear;
        this.title = title;
    }

    public Book() {
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Book{");
        sb.append("title=").append(title);
        sb.append(", author=").append(author);
        sb.append(", publicationYear=").append(publicationYear);
        sb.append(", isbn=").append(isbn);
        sb.append(", price=").append(price);
        sb.append('}');
        return sb.toString();
    }
}
