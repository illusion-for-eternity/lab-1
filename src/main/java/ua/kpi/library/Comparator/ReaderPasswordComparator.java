package ua.kpi.library.Comparator;

import ua.kpi.library.Reader;

import java.util.Comparator;

public class ReaderPasswordComparator implements Comparator<Reader> {
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

        if (a.getPassword() == null && b.getPassword() == null) {
            return 0;
        }
        if (a.getPassword() == null) {
            return -1;
        }
        if (b.getPassword() == null) {
            return 1;
        }
        return a.getPassword().length() - b.getPassword().length();
    }
}
