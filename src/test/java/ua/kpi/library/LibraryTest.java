package ua.kpi.library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LibraryTest {
    Library library;

    @BeforeEach
    public void setup() {
        //Given
        library = new Library(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void LendNotAvailableBook() {
        //Given
        Book book = new Book("title", "authot", "genre");
        book.borrow();
        Reader reader = mock(Reader.class);

        //When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.LendBook(book, reader));

        //Then
        Assertions.assertEquals("This book was taken by another reader", exception.getMessage());
    }

    @Test
    public void GetNonExsistantReader() {
        //Given
        library.setReader(new Reader("A", "B", "123"));
        Reader reader = mock(Reader.class);
        when(reader.getFirstName()).thenReturn("Miku");
        when(reader.getPassword()).thenReturn("39");

        //When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getReader(reader.getFirstName(), reader.getPassword()));

        //Then
        Assertions.assertEquals("Reader not found", exception.getMessage());
    }

    @Test
    public void GetExsistantReader() {
        //Given
        library.setReader(new Reader("Miku", "Hatsune", "39"));
        Reader reader = new Reader("Miku", "Hatsune", "39");

        //When
        Reader result = library.getReader(reader.getFirstName(), reader.getPassword());

        //Then
        Assertions.assertEquals(reader, result);
    }

    @Test
    public void GetNotAvailableBook() {
        //Given
        Book book = new Book("title", "authot", "genre");
        book.borrow();
        library.setBook(book);

        //When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getBook(book.getTitle()));

        //Then
        Assertions.assertEquals("This book currently isn't available", exception.getMessage());
    }

    @Test
    public void GetNonExistantBook() {
        //Given
        Book book = new Book("title", "authot", "genre");
        library.setBook(book);

        //When
        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getBook("title2"));

        //Then
        Assertions.assertEquals("There is no book with that title", exception.getMessage());
    }

    @Test
    public void FilterWithNoBooks() {
        //When
        var result = library.GetFilteredByAuthor("Osamu Dazai");

        //Then
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void FilterBooksByGenre() {
        //Given
        Book book1 = new Book("No longer human", "Osamu Dazai", "Novel");
        Book book2 = new Book("Doctor Serafikus", "Domogtovich", "Novel");
        library.setBook(book1);
        library.setBook(book2);
        library.setBook(new Book("The Metamorphosis", "Franz Kafka", "Novella"));

        //When
        var result = library.GetFilteredByGenre("Novel");

        //Then
        ArrayList<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        Assertions.assertEquals(list, result);
    }
}