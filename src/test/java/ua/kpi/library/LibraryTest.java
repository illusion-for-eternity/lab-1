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
        library = new Library(new ArrayList<>(), new ArrayList<>());
    }

    @Test
    public void LendNotAvailableBook() {
        Book book = new Book("title", "authot", "genre");
        book.borrow();
        Reader reader = mock(Reader.class);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.LendBook(book, reader));

        Assertions.assertEquals("This book was taken by another reader", exception.getMessage());
    }

    @Test
    public void GetNonExsistantReader() {

        library.setReader(new Reader("A", "B", "123"));
        Reader reader = mock(Reader.class);
        when(reader.getFirstName()).thenReturn("Miku");
        when(reader.getPassword()).thenReturn("39");

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getReader(reader.getFirstName(), reader.getPassword()));

        Assertions.assertEquals("Reader not found", exception.getMessage());
    }

    @Test
    public void GetExsistantReader() {

        library.setReader(new Reader("Miku", "Hatsune", "39"));
        Reader reader = new Reader("Miku", "Hatsune", "39");

        Reader result = library.getReader(reader.getFirstName(), reader.getPassword());

        Assertions.assertEquals(reader, result);
    }

    @Test
    public void GetNotAvailableBook() {
        Book book = new Book("title", "authot", "genre");
        book.borrow();
        library.setBook(book);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getBook(book.getTitle()));

        Assertions.assertEquals("This book currently isn't available", exception.getMessage());
    }

    @Test
    public void GetNonExistantBook() {
        Book book = new Book("title", "authot", "genre");
        book.borrow();
        library.setBook(book);

        IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class,
                () -> library.getBook("title2"));

        Assertions.assertEquals("There is no book with that title", exception.getMessage());
    }

    @Test
    public void FilterWithNoBooks() {
        var result = library.GetFilteredByAuthor("Osamu Dazai");
        Assertions.assertEquals(new ArrayList<>(), result);
    }

    @Test
    public void FilterBooksByGenre() {
        Book book1 = new Book("No longer human", "Osamu Dazai", "Novel");
        Book book2 = new Book("Doctor Serafikus", "Domogtovich", "Novel");
        library.setBook(book1);
        library.setBook(book2);
        library.setBook(new Book("The Metamorphosis", "Franz Kafka", "Novella"));

        var result = library.GetFilteredByGenre("Novel");

        ArrayList<Book> list = new ArrayList<>();
        list.add(book1);
        list.add(book2);
        Assertions.assertEquals(list, result);
    }
}