package ua.kpi.library.Comparator;

import ua.kpi.library.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {
    public int compare(Book a,Book b){
return a.getTitle().compareTo(b.getTitle());
    }
}
