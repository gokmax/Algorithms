import java.util.Arrays;

public class testMyMergeSort {


    public static void mergeArray(int[] a, int first, int mid, int last, int[] temp) {

        int len = a.length;
        mid = (first + last) / 2;
        int i = first, j = mid + 1;
        int m = mid,   n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
            }
        }

        while (i <= m) 
            temp[k++] = a[i++];
        while (j <= n) 
            temp[k++] = a[j++];

        for (int ii = 0; ii < k; ii++ ) {
            a[first + ii] = temp[ii];
        }

    }

    public static void mergeSort(int[] a, int first, int last, int[] temp) {
        if (first < last) {
            int mid = (first + last) / 2;
            mergeSort(a, first, mid, temp);
            mergeSort(a, mid + 1, last, temp);
            mergeArray(a, first, mid, last, temp);
        }
    }

    public static void realMergeSort(int[] a, int n) {
        
        int[] p = new int[n];
        mergeSort(a, 0, n - 1, p);
    }

    public static void main (String [] args) {
        int[] a = {2, 1, 4, 5, 6, 7, 8};

        realMergeSort(a, 7);
        for (int i = 0; i < 7; i ++) StdOut.println(a[i]);
    }
}
