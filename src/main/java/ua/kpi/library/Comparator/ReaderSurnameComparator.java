package ua.kpi.library.Comparator;

import java.util.Comparator;
import ua.kpi.library.Reader;

public class ReaderSurnameComparator implements Comparator<Reader> {
    public int compare(Reader a,Reader b){
        return a.getLastName().compareTo(b.getLastName());
    }
}
