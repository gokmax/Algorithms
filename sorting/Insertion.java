/*
 * Sorts a sequence of strings from standard input using insertion sort.
 */

import java.util.Comparator;

public class Insertion {

    // Use natural order and Comparable interface
    public static void sort(Comparable[] a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j --) {
                exch(a, j, j - 1);
            }
            assert isSorted(a, 0, i); // the sequence 0~i is sorted.
        }
        assert isSorted(a);
    }

    // Return a permutation that gives the elements in a[] in ascending order
    // do not change the original array a[]
    public static int[] indexSort(Comparable[] a) {
        int N = a.length;
        int[] index = new int[N];
        for (int i = 0; i < N; i ++) index[i] = i;

        for (int i = 0; i < N; i ++) {
            for (int j = i; j > 0 && less(a[index[j]], a[index[j - 1]]); j --) {
                exch(index, j, j - 1);
            }
        }

        return index;
    }

    private static boolean less(Comparable v, Comparable u) {
        return (v.compareTo(u) < 0);
    }

    // for the swap of A array
    private static void exch(int[] a, int i, int j) {
        int swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // for the swap of index arraR
    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo; i <= hi; i ++) {
            if (less(a[i], a[i - 1])) return false;
        }
        return true;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i ++) StdOut.println(a[i]);
    }

    public static void main (String [] args) {
        String[] a = StdIn.readStrings();
        Insertion.sort(a);
        show(a);
    }
}
