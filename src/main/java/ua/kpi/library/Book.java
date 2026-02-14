package ua.kpi.library;
import java.util.Objects;

//prototype for books
public class Book {

    private String title;

    private String author;

    private String genre;

    private boolean lended=false;

    public  Book(String title,String author,String genre){
        this.title=title;
        this.author=author;
        this.genre=genre;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", lended=" + lended +
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

    public void setTitle(String title)
    {
        this.title=title;
    }

    public String getAuthor(){
        return author;
    }

    public void setAuthor(String author)
    {
        this.author=author;
    }

    public String getGenre(){
        return genre;
    }

    public void setGenre(String genre)
    {
        this.genre=genre;
    }

    public boolean getLended() {
        return lended;
    }

    public void setLended(boolean lended) {
        this.lended = lended;
    }
}
