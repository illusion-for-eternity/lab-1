package ua.kpi.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ReaderTest {

    Reader reader;

    @BeforeEach
    public void setup() {
        //Given
        reader = new Reader("Sherlok", "Holmes", "01010101");
    }

    @Test
    public void returnExistingBookFromReader() {
        //Given
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);

        when(book1.getTitle()).thenReturn("1984");
        when(book2.getTitle()).thenReturn("Animal Farm");

        reader.addBookToReader(book1);
        reader.addBookToReader(book2);

        //When
        Book result = reader.getBook(book1.getTitle());

        //Then
        Assertions.assertEquals(book1, result);
    }

    @Test
    public void returnNonExistingBookFromReader() {
        //Given
        Book book1 = mock(Book.class);
        when(book1.getTitle()).thenReturn("title");

        //When
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> reader.getBook(book1.getTitle()));

        //Then
        Assertions.assertEquals("You don't have this book", exeption.getMessage());
    }

    @Test
    public void lendTheSameBookToReader() {
        //Given
        Book book1 = mock(Book.class);
        Book book2 = book1;
        reader.addBookToReader(book1);

        //When
        IllegalArgumentException exeption = Assertions.assertThrows(IllegalArgumentException.class, ()
                -> reader.addBookToReader(book2));

        //Then
        Assertions.assertEquals("Reader already has this book", exeption.getMessage());
    }

    @Test
    public void SetShortReaderPassword(){
        //Then
        Assertions.assertThrows(RuntimeException.class, () -> reader.setPassword("12"));
    }
}