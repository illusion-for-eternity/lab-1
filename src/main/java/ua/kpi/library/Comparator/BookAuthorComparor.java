package ua.kpi.library.Comparator;

import ua.kpi.library.Book;

import java.util.Comparator;

public class BookAuthorComparor implements Comparator<Book> {
    public int compare(Book a, Book b) {
        if(a==null && b==null){
            return 0;
        }
        if(a==null){
            return -1;
        }
        if(b==null){
            return 1;
        }

        if(a.getAuthor()==null && b.getAuthor()==null){
            return 0;
        }
        if(a.getAuthor()==null){
            return -1;
        }
        if(b.getAuthor()==null){
            return 1;
        }
        return a.getAuthor().compareTo(b.getAuthor());
    }
}
