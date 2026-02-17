package ua.kpi.library;

import java.util.ArrayList;
import java.util.Objects;

public class Reader {

    private ArrayList<Book> booksTaken=new ArrayList<>();

    private String firstName;

    private String lastName;

    private String password;

    public Reader(String firstName,String lastName,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public Book getBook(String title) {
        for(Book book:booksTaken)
        {
            if(Objects.equals(book.getTitle(), title))
            {
                return book;
            }
        }

        throw new IllegalArgumentException("You don't have this book");
    }

    public void addBookToReader(Book book) {
        if(booksTaken.contains(book))
        {
            throw new IllegalArgumentException("Reader already has this book");
        }
        booksTaken.add(book);
    }

    public void returnBookToLibrary(Book book) {
        if(!booksTaken.contains(book))
        {
            throw new IllegalArgumentException("You don't have this book");
        }
        booksTaken.remove(book);
        book.returnBook();
    }

    public ArrayList<Book> GetAllReaderBooks() {
return  booksTaken;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reader reader = (Reader) o;
        return Objects.equals(booksTaken, reader.booksTaken) && Objects.equals(firstName, reader.firstName) && Objects.equals(lastName, reader.lastName) && Objects.equals(password, reader.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(booksTaken, firstName, lastName, password);
    }

    @Override
    public String toString() {
        return "Reader{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
