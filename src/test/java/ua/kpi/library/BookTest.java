package ua.kpi.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

    Book book;

    @BeforeEach
    public void setup() {
        //Given
        book = new Book("title", "authot", "genre");
    }


    @Test
    void BorrowUnavailableBook() {
        //Given
        book.borrow();

        //When
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                () -> book.borrow());

        //Then
        Assertions.assertEquals("Book is already borrowed", exception.getMessage());
    }

    @Test
    void returnNotBorrowedBook() {
        //When
        IllegalStateException exception = Assertions.assertThrows(IllegalStateException.class,
                () -> book.returnBook());

        //Then
        Assertions.assertEquals("Book is not borrowed", exception.getMessage());
    }
}