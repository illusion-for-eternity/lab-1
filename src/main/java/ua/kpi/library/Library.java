package ua.kpi.library;

import java.util.*;

public class Library {

    private ArrayList<Book> books;

    private ArrayList<Reader> readers;

    public Library(ArrayList<Book> books, ArrayList<Reader> readers)
    {
        this.books=books;
        this.readers=readers;
    }

    public void PrintBooks()
    {
        for(Book book:books)
        {
            System.out.println(book.toString());
        }
    }

    public void PrintReaders()
    {
        for(Reader reader:readers)
        {
            System.out.println(reader.toString());
        }
    }

    public void FilterBooks(String author, String genre)
    {
        for(Book book:books)
        {
            if(author!=null && genre!=null)
            {
                if(Objects.equals(book.getAuthor(), author) && Objects.equals(book.getGenre(), genre))
                {
                    System.out.println(book.toString());
                }
            }
            else if(genre!=null)
            {
                if(Objects.equals(book.getGenre(), genre))
                {
                    System.out.println(book.toString());
                }
            }
            else if(author!=null)
            {
                if(Objects.equals(book.getAuthor(), author))
                {
                    System.out.println(book.toString());
                }
            }
        }
    }

    public Book getBook(String title)
    {
        for(Book book:books)
        {
            if(Objects.equals(book.getTitle(), title))
            {
                if(book.getAvailable())
                {
                    return book;
                }
                else
                {
                    throw new IllegalArgumentException("This book currently isn't available") ;
                }
            }
        }
        throw new IllegalArgumentException("There is no book with that title") ;
    }

    public Book getBook(int index)
    {
        return books.get(index);
    }

    public Reader getReader(int index)
    {
        return readers.get(index);
    }

    public void LendBook(Book book,Reader reader)
    {
       if(book.getAvailable())
       {
           reader.addBookToReader(book);
           book.setAvailable(false);
           System.out.println(reader.getLastName()+ " " + reader.getFirstName()+ " took a book - "+book.getTitle());
       }
       else
       {
           throw new IllegalArgumentException("This book was taken by another reader");
       }
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setBook(Book book)
    {
        books.add(book);
    }

    public void removeBook(Book book)
    {
        books.remove(book);
    }

    public void setReader(Reader reader)
    {
        readers.add(reader);
    }

    public void removeReader(Reader reader)
    {
        readers.remove(reader);
    }
}
