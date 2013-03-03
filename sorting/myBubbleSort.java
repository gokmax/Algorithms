import java.util.Arrays;

public class myBubbleSort {

    public static void sort(int[] a) {
        int len = a.length;
        for (int i = len - 1; i > 0; i --) {
            for (int j = 0; j < i; j ++) {
                if (a[j] > a[j + 1]) {
                    int temp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = temp;
                }
            }
        }

    }

    private static boolean isSorted(int[] a) {

        int len = a.length;
        for (int i = 0; i < len - 1; i ++) {
            if (a[i] > a[i + 1]) return false;
        }
        return true;
    }

    public static void main (String [] args) {
        int a[] = {3, 2, 1, 4, 7, 5, 6, 8, 9};
        myBubbleSort.sort(a);
        int len = a.length;
        StdOut.println(isSorted(a));
    }
}
