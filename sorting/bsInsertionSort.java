import java.util.Arrays;

public class bsInsertionSort{
    
    public static void sort(int[] a) {
        int N = a.length;
        for (int i = 1; i < N; i ++) {
            int key = a[i];
            int j = i;

            int low = 0, high = i - 1; // low ~ high is sorted.
            int mid = (low + high) / 2; // mid must be assigned value in any condition.
            while (low <= high) {
                mid = (low + high) / 2;
                if (a[i] < a[mid]) 
                    high = mid - 1;
                if (a[i] > a[mid]) 
                    low = mid + 1;
            }
            // now find the a[i]'s exact place -- mid.
            for (int k = i; k > mid ; --k) {
                a[k] = a[k - 1];
            }
            a[low] = key;

            //while (j >= 1 && key < a[j - 1]) {
                //a[j] = a[j - 1];
                //j --;
            //}
            //a[j] = key;
        }
    }

    public static void main (String [] args) {
        int[] a = {3, 2, 1, 5, 6, 7, 4};
        bsInsertionSort.sort(a);
        for (int i = 0; i < 7; i ++) StdOut.println(a[i]);
    }
}
