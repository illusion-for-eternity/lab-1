package ua.kpi.library.files;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.kpi.library.Book;
import ua.kpi.library.Reader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ImportDataTest {
    @Test
    public void ImportFromNonExistantFile() {
        ImportData importData = new ImportData("???.txt");

        Assertions.assertThrows(RuntimeException.class, () -> importData.importObjects());
    }

    @Test
    public void CheckImportedObjects() throws IOException {
        Book book1 = mock(Book.class);
        Book book2 = mock(Book.class);

        Reader reader1 = mock(Reader.class);

        ArrayList<Book> books = new ArrayList<>();
        books.add(book1);
        books.add(book2);

        ArrayList<Reader> readers = new ArrayList<>();
        readers.add(reader1);


        ExportData exportData = new ExportData("objects.txt");
        exportData.exportObjects(books, readers);

        ImportData importData = new ImportData("objects.txt");
        ArrayList list = importData.importObjects();

        int count=books.size()+readers.size();
        Assertions.assertEquals(count, list.size());
    }
}