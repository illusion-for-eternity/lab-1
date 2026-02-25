package ua.kpi;

import ua.kpi.library.Book;
import ua.kpi.library.Comparator.*;
import ua.kpi.library.Library;
import ua.kpi.library.Reader;
import ua.kpi.library.files.ExportData;
import ua.kpi.library.files.ImportData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try {
            ArrayList<Book> books = new ArrayList<Book>();
            books.add(new Book("No longer human", "Osamu Dazai", "Novel"));
            books.add(new Book("The 48 Laws of Power", "Robert Greene", "Non-fiction"));
            books.add(new Book("1984", "George Orwell", "Dystopian"));
            books.add(new Book("Doctor Serafikus", "Domogtovich", "Novel"));
            books.add(new Book("The Metamorphosis", "Franz Kafka", "Novella"));
            books.add(new Book("The Book of Five Rings", "Miyamoto Musashi", "Strategy"));
            books.add(new Book("The Castle", "Franz Kafka", "Novel"));

            ArrayList<Reader> readers = new ArrayList<Reader>();
            Reader reader1 = new Reader("Miku", "Hatsune", "393939");
            readers.add(reader1);
            readers.add(new Reader("Rin", "Kagamine", "012345"));
            readers.add(new Reader("Len", "Kagamine", "54321"));

            Library library = new Library(books, readers);

            Scanner in = new Scanner(System.in);

            System.out.println("Welcome!");
            System.out.print("Write your first name: ");
            String name= in.nextLine();
            System.out.print("Write your password: ");
            String password= in.nextLine();
            var reader = library.getReader(name, password);
            System.out.println();

            //7
            String[] menuOptions = new String[]{"1. Get book", "2. Return book", "3. See all books",
                    "4. Filter books", "5. Output all user's books", "6. Leave the library"};
            boolean visitLibrary = true;

            while (visitLibrary) {
                System.out.println();
                PrintArray(menuOptions);
                System.out.println();
                System.out.print("Option:");
                int num = Integer.parseInt(in.nextLine());
                if (num == 1) {
                    System.out.print("What book would u like to get: ");
                    String title = in.nextLine();
                    var book = library.getBook(title);
                    library.LendBook(book, reader);
                    System.out.println(reader.getFirstName() + " took the book: " + book.getTitle());
                } else if (num == 2) {
                    System.out.print("What book would u like to return: ");
                    String title = in.nextLine();
                    var book = reader.getBook(title);
                    reader.returnBookToLibrary(book);
                    System.out.println(reader.getFirstName() + " returned the book: " + book.getTitle());
                } else if (num == 3) {
                    System.out.println("Books catalog:");
                    var booksList = library.GetAllBooks();
                    PrintList(booksList);
                } else if (num == 4) {
                    System.out.print("Filter by genre, author or both: ");
                    String filterOption = in.nextLine();
                    ArrayList list = new ArrayList<>();

                    if (Objects.equals(filterOption, "both")) {
                        System.out.print("Write author:");
                        String author = in.nextLine();
                        System.out.print("Write genre:");
                        String genre = in.nextLine();
                        list = library.GetFilteredBooks(author, genre);
                    } else if (Objects.equals(filterOption, "genre")) {
                        System.out.print("Write genre:");
                        String genre = in.nextLine();
                        list = library.GetFilteredByGenre(genre);
                    } else if (Objects.equals(filterOption, "author")) {
                        System.out.print("Write author:");
                        String author = in.nextLine();
                        list = library.GetFilteredByAuthor(author);
                    }

                    PrintList(list);
                } else if (num == 5) {
                    System.out.println("User's books:");
                    var userBooks = reader.GetAllReaderBooks();
                    PrintList(userBooks);
                } else if (num == 6) {
                    visitLibrary = false;
                }
            }

            //6

            System.out.print("Sort books by (title,author): ");
            String sortOption = in.nextLine();
            if (Objects.equals(sortOption, "title")) {
                books.sort(new BookTitleComparator());
            } else if (Objects.equals(sortOption, "author")) {
                books.sort(new BookAuthorComparor());
            }

            System.out.print("Sort reader by (name,password[Length]): ");

            Comparator<Reader> totalComparator = new ReaderNameComparator().thenComparing(new ReaderSurnameComparator());

            String sortOption2 = in.nextLine();
            if (Objects.equals(sortOption2, "name")) {
                readers.sort(totalComparator);
            } else if (Objects.equals(sortOption2, "password")) {
                readers.sort(new ReaderPasswordComparator());
            }

            ExportData export = new ExportData("objects.txt");
            export.exportObjects(books, readers);

            System.out.println("\nExport of objects complete:\n");
            System.out.println("\nImport of objects:\n");

            ImportData importText = new ImportData("objects.txt");
            ArrayList<String> lines = importText.importObjects();
            PrintList(lines);

        } catch (IllegalArgumentException ex) {
            System.out.println("Error:" + ex.getMessage());
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }

    }

    static <T> void PrintList(ArrayList<T> list) {
        if (list.isEmpty()) {
            System.out.println("List is empty");
            return;
        }
        for (T item : list) {
            System.out.println(item.toString());
        }
    }

    static void PrintArray(String[] array) {
        for (String str : array) {
            System.out.print(str + "| ");
        }
    }
}