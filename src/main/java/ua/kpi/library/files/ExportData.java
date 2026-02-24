package ua.kpi.library.files;

import ua.kpi.library.Book;
import ua.kpi.library.Reader;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ExportData {
    private String filePath;

    public ExportData(String path){
        this.filePath=path;
    }

    public String getFilePath() {
        return filePath;
    }

    public void exportObjects(ArrayList<Book> books, ArrayList<Reader> readers ){
        if (books == null || readers == null) {
            throw new IllegalArgumentException("Books or readers list is null");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Book book : books) {
                String bookInfo = book.toString();
                bw.write(bookInfo);
                bw.write("\n");
            }

            for (Reader reader2 : readers) {
                String readerInfo = reader2.toString();
                bw.write(readerInfo);
                bw.write("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
