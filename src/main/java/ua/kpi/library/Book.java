package ua.kpi.library;
import java.util.Objects;

public class Book {

    private String title;

    private String author;

    private String genre;

    private boolean available = true;

    public Book(String title, String author, String genre) {
        this.title = title;
        this.author = author;
        this.genre = genre;
    }

    public void borrow() {
        if (available) {
            available = false;
            return;
        }
        throw new IllegalStateException("Book is already borrowed");
    }

    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is not borrowed");
        }
        available = true;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", available=" + available +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(title, book.title) && Objects.equals(author, book.author) && Objects.equals(genre, book.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, genre);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public boolean getAvailable() {
        return available;
    }
}
