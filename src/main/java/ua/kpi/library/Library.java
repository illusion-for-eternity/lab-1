package ua.kpi.library;

import java.util.*;

public class Library {

    private ArrayList<Book> books;

    private ArrayList<Reader> readers;

    public Library(ArrayList<Book> books, ArrayList<Reader> readers) {
        this.books=books;
        this.readers=readers;
    }

    public ArrayList<Book> GetAllBooks() {
return books;
    }

    public ArrayList<Reader> GetAllReaders() {
return readers;
    }

    public ArrayList<Book> GetFilteredBooks(String author, String genre) {
        ArrayList<Book> filteredBooks= new ArrayList<>();

        for(Book book:books)
        {
            if(author!=null && genre!=null)
            {
                if(Objects.equals(book.getAuthor(), author) && Objects.equals(book.getGenre(), genre))
                {
                    filteredBooks.add(book);
                }
            }
            else if(genre!=null)
            {
                if(Objects.equals(book.getGenre(), genre))
                {
                    filteredBooks.add(book);
                }
            }
            else if(author!=null)
            {
                if(Objects.equals(book.getAuthor(), author))
                {
                    filteredBooks.add(book);
                }
            }
        }

        return filteredBooks;
    }

    public Book getBook(String title) {
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

    public Book getBook(int index) {
        if(books.get(index).getAvailable())
        {
            return books.get(index);
        }
        return null;
    }

    public Reader getReader(int index) {
        return readers.get(index);
    }

    public void LendBook(Book book,Reader reader) {
       if(book.getAvailable())
       {
           reader.addBookToReader(book);
           book.borrow();
       }
       else
       {
           throw new IllegalArgumentException("This book was taken by another reader");
       }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Library library = (Library) o;
        return Objects.equals(books, library.books) && Objects.equals(readers, library.readers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(books, readers);
    }

    public void setBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void setReader(Reader reader) {
        readers.add(reader);
    }

    public void removeReader(Reader reader) {
        readers.remove(reader);
    }
}
