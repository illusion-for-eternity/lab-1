package ua.kpi.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    Book book;

    @BeforeEach
    public void setup() {
        book = new Book("title","authot","genre");
    }


    @Test
    void BorrowUnavailableBook() {
       book.borrow();

        IllegalStateException exception= Assertions.assertThrows(IllegalStateException.class,
                () -> book.borrow());

        Assertions.assertEquals("Book is already borrowed",exception.getMessage());
    }

    @Test
    void returnNotBorrowedBook() {
        IllegalStateException exception= Assertions.assertThrows(IllegalStateException.class,
                () -> book.returnBook());

        Assertions.assertEquals("Book is not borrowed",exception.getMessage());
    }
}