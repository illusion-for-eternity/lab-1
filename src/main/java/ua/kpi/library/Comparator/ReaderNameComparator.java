package ua.kpi.library.Comparator;

import ua.kpi.library.Reader;

import java.util.Comparator;

public class ReaderNameComparator implements Comparator<Reader> {
    public int compare(Reader a, Reader b) {
        if (a == null && b == null) {
            return 0;
        }
        if (a == null) {
            return -1;
        }
        if (b == null) {
            return 1;
        }

        if (a.getFirstName() == null && b.getFirstName() == null) {
            return 0;
        }
        if (a.getFirstName() == null) {
            return -1;
        }
        if (b.getFirstName() == null) {
            return 1;
        }
        return a.getFirstName().compareTo(b.getFirstName());
    }
}
