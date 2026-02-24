package ua.kpi.library.Comparator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ua.kpi.library.Book;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ReaderNullTitleComparatorTest {
    @Test
    public void NullTitleComparatorTest() {
        Book book1=new Book(null,null,null );
        Book book2=new Book(null,null,null );

        BookTitleComparator comparator= new BookTitleComparator();
        int result=comparator.compare(book1,book2);

        Assertions.assertEquals(0,result);
    }

    @Test
    public void BothNullBookComparatorTest() {
        BookTitleComparator comparator= new BookTitleComparator();
        int result=comparator.compare(null,null);

        Assertions.assertEquals(0,result);
    }

    @Test
    public void OneNullBookComparatorTest() {
        BookTitleComparator comparator= new BookTitleComparator();
        int result=comparator.compare(null,new Book("title",null,null));

        Assertions.assertEquals(-1,result);
    }
}