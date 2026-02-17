package ua.kpi;
import ua.kpi.library.Book;
import ua.kpi.library.Library;
import ua.kpi.library.Reader;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

//rewrite GetFilteredBooks method(override)
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
            readers.add(new Reader("Rin","Kagamine","12345"));
            readers.add(new Reader("Len","Kagamine","54321"));

            Library library= new Library(books,readers);

//            //Part-1: Equals
//            Book conceteBook=new Book("The Metamorphosis", "Franz Kafka", "Novella");
//            System.out.println("book.equals(): "+books.get(4).equals(conceteBook));
//
//            //Get all books
//            ArrayList<Book> allBooks=library.GetAllBooks();
//            PrintList(allBooks);
//
//            //filter them
//            ArrayList<Book> filteredBooks=library.GetFilteredBooks(null,"Novel");
//            PrintList(filteredBooks);
//
//            //library lends the book
//            var book1=library.getBook("No longer human");
//            System.out.println(book1.getTitle()+" is available: "+book1.getAvailable() );
//            library.LendBook(book1,reader1);
//            System.out.println(book1.getTitle()+" is available: "+book1.getAvailable() );
//
//            //reader takes the book
//            var book2 = library.getBook("1984");
//            //reader1.addBookToReader(book1);---exeption
//            reader1.addBookToReader(book2);
//
//            //check all reader1's books
//            System.out.println("\nAll "+ reader1.getFirstName()+"'s books:");
//            ArrayList<Book> readersBook= reader1.GetAllReaderBooks();
//            PrintList(readersBook);
//
//            //return a book
//            reader1.returnBookToLibrary(book1);
//            System.out.println("\nAll "+ reader1.getFirstName()+"'s books:");
//            ArrayList<Book> readersBook2= reader1.GetAllReaderBooks();
//            PrintList(readersBook2);



            Scanner in= new Scanner(System.in);

            System.out.println("Welcome!");
//            System.out.print("Write your first name: ");
//            String name= in.next();
//            System.out.print("Write your password: ");
//            String password= in.next();
//            var reader=library.getReader(name,password);
            var reader=library.getReader("Miku","39");

            //7
            boolean visitLibrary=true;

            while(visitLibrary)
            {
                System.out.println();
                System.out.println("1. Get book");
                System.out.println("2. Return book");
                System.out.println("3. See all books");
                System.out.println("4. Filter books");
                System.out.println("5. Output all user's books");
                System.out.println("6. Leave the library");
                System.out.print("Option:");
                int num=Integer.parseInt(in.nextLine());
                if(num==1)
                {
                    System.out.print("What book would u like to get: ");
                    String title= in.nextLine();
                    var book=library.getBook(title);
                    library.LendBook(book,reader);
                    System.out.println(reader.getFirstName()+" took the book: "+ book.getTitle());
                }
                else if (num==2)
                {
                    System.out.print("What book would u like to return: ");
                    String title= in.nextLine();
                    var book= reader.getBook(title);
                    reader.returnBookToLibrary(book);
                    System.out.println(reader.getFirstName()+" returned the book: "+ book.getTitle());
                }
                else if(num==3)
                {
                    System.out.println("Books catalog:");
                    var booksList=library.GetAllBooks();
                    PrintList(booksList);
                }
                else if(num==4)
                {
                    System.out.print("Filter by genre, author or both: ");
                    String filterOption= in.nextLine();
                    ArrayList list= new ArrayList<>();

                    if(Objects.equals(filterOption, "both"))
                    {
                        System.out.print("Write author:");
                        String author= in.nextLine();
                        System.out.print("Write genre:");
                        String genre= in.nextLine();
                        list=library.GetFilteredBooks(author,genre);
                    }
                    else if(Objects.equals(filterOption, "genre"))
                    {
                        System.out.print("Write genre:");
                        String genre= in.nextLine();
                        list=library.GetFilteredByGenre(genre);
                    }
                    else if(Objects.equals(filterOption, "author"))
                    {
                        System.out.print("Write author:");
                        String author= in.nextLine();
                        list=library.GetFilteredByAuthor(author);
                    }

                    PrintList(list);
                }
                else if(num==5)
                {
                    System.out.println("User's books:");
                    var userBooks=reader.GetAllReaderBooks();
                    PrintList(userBooks);
                }
                else if(num==6)
                {
                    visitLibrary=false;
                }
            }

            //6

            try(BufferedWriter bw= new BufferedWriter(new FileWriter("objects.txt")))
            {
                for(Book book: books)
                {
                    String bookInfo=book.toString();
                    bw.write(bookInfo);
                    bw.write("\n");
                }
            }
            catch (IOException ex)
            {
                System.out.println(ex.getMessage());
            }

            try(BufferedReader br = new BufferedReader(new FileReader("objects.txt")))
            {
                String s;
                while((s=br.readLine())!=null)
                {
                    System.out.println(s);
                }
            }
            catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }
        catch(IllegalArgumentException ex)
        {
            System.out.println("Error:"+ex.getMessage());
        }
        catch (Exception ex)
        {
            System.out.println("Error:"+ex.getMessage());
        }

    }

    static <T>void PrintList(ArrayList<T> list)
    {
        if(list.isEmpty())
        {
            System.out.println("List is empty");
            return;
        }
        for (T item : list) {
            System.out.println(item.toString());
        }
    }
}