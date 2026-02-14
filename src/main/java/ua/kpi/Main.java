package ua.kpi;
import ua.kpi.library.Book;
import ua.kpi.library.Library;
import ua.kpi.library.Reader;

import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        try
        {
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("No longer human", "Osamu Dazai", "Novel"));
            books.add(new Book("The 48 Laws of Power", "Robert Greene", "Non-fiction"));
            books.add(new Book("1984", "George Orwell", "Dystopian"));
            books.add(new Book("Doctor Serafikus", "Domogtovich", "Novel"));
            books.add(new Book("The Metamorphosis", "Franz Kafka", "Novella"));
            books.add(new Book("The Book of Five Rings", "Miyamoto Musashi", "Strategy"));

            ArrayList<Reader> readers = new ArrayList<Reader>();
            Reader reader1=new Reader("Miku","Hatsune","39");
            readers.add(reader1);
            Reader reader2=new Reader("Rin","Kagamine","12345");
            readers.add(reader2);
            Reader reader3=new Reader("Len","Kagamine","54321");
            readers.add(reader3);

            Library library= new Library(books,readers);

            //Part-1: Equals
            Book book2=new Book("The Metamorphosis", "Franz Kafka", "Novella");
            System.out.println("book.equals(): "+books.get(4).equals(book2));

            //Get all books
            library.PrintBooks();

            //filter them
            library.FilterBooks(null,"Novel");

            //reader gets a book
            //reade1.
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}