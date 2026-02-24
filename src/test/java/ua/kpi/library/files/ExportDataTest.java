package ua.kpi.library.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ua.kpi.library.Book;
import ua.kpi.library.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ExportDataTest {
    Book book1;
    Reader reader;

    @BeforeEach
    public void setup() {
        book1 = mock(Book.class);
        reader = mock(Reader.class);
    }


    @Test
    public void ExportList() throws IOException {
        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);

        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(reader);

        ExportData export = new ExportData("objects.txt");
        when(book1.toString()).thenReturn("1984");
        when(reader.toString()).thenReturn("Sherlock Holmes");
        export.exportObjects(books, readers);

        List<String> lines = Files.readAllLines(Path.of("objects.txt"));

        Assertions.assertTrue(lines.contains(book1.toString()));
        Assertions.assertTrue(lines.contains(reader.toString()));
    }

    @Test
    public void ExportEmptyList() throws IOException {

        ExportData export = new ExportData("objects.txt");
        export.exportObjects(new ArrayList<Book>(), new ArrayList<Reader>());

        List<String> lines = Files.readAllLines(Path.of("objects.txt"));

        Assertions.assertTrue(lines.isEmpty());
    }

    @Test
    public void ExportNullList() throws IOException {

        ExportData export = new ExportData("objects.txt");

        assertThrows(IllegalArgumentException.class, () -> export.exportObjects(null, null));
    }
}