/*
 * Sorts a sequence of strings from standard input using selection sort.
 */

import java.util.Comparator;

public class Selection {

    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) { 
            // personally I think that the Nth element is sorted for it is in the Nth place. So it is OK to code i < N - 1;
            int min = i;
            for (int j = i + 1; j < N; j ++) {
                if (less(a[j], a[min])) 
                    min = j;
            }
            // personally I think we can add the line "if (a[i] != a[min]) "
            exch(a, i, min);
            assert isSorted(a, 0, i);
        }
        assert isSorted(a);
    }
    

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    /*
     * Test if an array is sorted
     */

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i ++) 
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i ++) 
            StdOut.println(a[i]);
    }

    public static void main (String [] args) {
        String[] a = StdIn.readStrings();
        Selection.sort(a);
        show(a);
    }

    // the official use the following code to complete the whole implement
    // wait to understand, cheer!

    /*===================================================================*/



    // use a custom order and Comparator interface - see Section 3.5
    public static void sort(Object[] a, Comparator c) {
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i+1; j < N; j++) {
                if (less(c, a[j], a[min])) min = j;
            }
            exch(a, i, min);
            assert isSorted(a, c, 0, i);
        }
        assert isSorted(a, c);
    }

    // is v < w ?
    private static boolean less(Comparator c, Object v, Object w) {
        return (c.compare(v, w) < 0);
    }

    // exchange a[i] and a[j]
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // is the array a[] sorted?
    private static boolean isSorted(Object[] a, Comparator c) {
        return isSorted(a, c, 0, a.length - 1);
    }

    // is the array sorted from a[lo] to a[hi]
    private static boolean isSorted(Object[] a, Comparator c, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(c, a[i], a[i-1])) return false;
        return true;
    }
}
