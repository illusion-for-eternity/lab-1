package ua.kpi.library;

import java.util.ArrayList;

public class Reader {

    private ArrayList<Book> booksTaken=new ArrayList<>();

    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Reader(String firstName,String lastName,String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
    }

    public void add(Book book)
    {
        booksTaken.add(book);
    }

    public void remove(Book book)
    {
        booksTaken.remove(book);
    }



//class collection
}
