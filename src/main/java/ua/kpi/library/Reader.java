package ua.kpi.library;

import java.util.ArrayList;

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

    public void addBookToReader(Book book)
    {
        if(booksTaken.contains(book))
        {
            throw new IllegalArgumentException("Reader already has this book");
        }
        booksTaken.add(book);
    }

    public void returnBookToLibrary(Book book)
    {
        if(!booksTaken.contains(book))
        {
            throw new IllegalArgumentException("Reader doesn't have this book");
        }
        booksTaken.remove(book);
        book.setAvailable(true);
    }

    public void PrintAllReaderBooks()
    {
        for(Book book:booksTaken)
        {
            System.out.println(book.getTitle());
        }
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
