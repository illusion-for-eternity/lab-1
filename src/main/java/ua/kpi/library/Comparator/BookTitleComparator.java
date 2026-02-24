package ua.kpi.library.Comparator;

import ua.kpi.library.Book;

import java.util.Comparator;

public class BookTitleComparator implements Comparator<Book> {
    public int compare(Book a, Book b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }

        if (a.getTitle() == null && b.getTitle() == null) {
            return 0;
        }
        if (a.getTitle() == null) {
            return -1;
        }
        if (b.getTitle() == null) {
            return 1;
        }
        return a.getTitle().compareTo(b.getTitle());
    }
}
