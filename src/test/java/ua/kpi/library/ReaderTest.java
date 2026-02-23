package ua.kpi.library;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReaderTest {

    Reader reader;

    @BeforeEach
    public void setup() {
        reader = new Reader("Sherlok", "Holmes", "01");
    }

    @Test
    public void returnExistingBookFromReader() {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);

        when(book1.getTitle()).thenReturn("1984");
        when(book2.getTitle()).thenReturn("Animal Farm");

        reader.addBookToReader(book1);
        reader.addBookToReader(book2);

        Book result = reader.getBook(book1.getTitle());
        Assertions.assertEquals(book1, result);
    }

    @Test
    public void returnNonExistingBookFromReader() {
        Book book1 = mock(Book.class);
        when(book1.getTitle()).thenReturn("title");

        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> reader.getBook(book1.getTitle()));

        Assertions.assertEquals("You don't have this book", exeption.getMessage());
    }

    @Test
    public void lendTheSameBookToReader()
    {
        Book book1= mock(Book.class);
        Book book2=book1;
        reader.addBookToReader(book1);

        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> reader.addBookToReader(book2));

        Assertions.assertEquals("Reader already has this book",exeption.getMessage());
    }
}