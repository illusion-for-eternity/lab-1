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
            Book conceteBook=new Book("The Metamorphosis", "Franz Kafka", "Novella");
            System.out.println("book.equals(): "+books.get(4).equals(conceteBook));

            //Get all books
            library.PrintBooks();

            //filter them
            library.FilterBooks(null,"Novel");

            //library lends the book
            var book1=library.getBook("No longer human");
            System.out.println(book1.getTitle()+" is available: "+book1.getAvailable() );
            library.LendBook(book1,reader1);
            System.out.println(book1.getTitle()+" is available: "+book1.getAvailable() );

            //reader takes the book
            var book2 = library.getBook("1984");
            //reader1.addBookToReader(book1);---exeption
            reader1.addBookToReader(book2);

            //check all reader1's books
            System.out.println("\nAll "+ reader1.getFirstName()+"'s books:");
            reader1.PrintAllReaderBooks();

            //return a book
            reader1.returnBookToLibrary(book1);
            System.out.println("\nAll "+ reader1.getFirstName()+"'s books:");
            reader1.PrintAllReaderBooks();
        }
        catch(IllegalArgumentException ex)
        {
            System.out.println(ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

    }
}