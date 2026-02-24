package ua.kpi.library.Comparator;

import java.util.Comparator;

import ua.kpi.library.Reader;

public class ReaderSurnameComparator implements Comparator<Reader> {
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

        if (a.getLastName() == null && b.getLastName() == null) {
            return 0;
        }
        if (a.getLastName() == null) {
            return -1;
        }
        if (b.getLastName() == null) {
            return 1;
        }
        return a.getLastName().compareTo(b.getLastName());
    }
}
