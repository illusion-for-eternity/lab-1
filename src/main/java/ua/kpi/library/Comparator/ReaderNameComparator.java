package ua.kpi.library.Comparator;

import ua.kpi.library.Reader;

import java.util.Comparator;

public class ReaderNameComparator implements Comparator<Reader> {
    public int compare(Reader a, Reader b){
        return a.getFirstName().compareTo(b.getFirstName());
    }
}
