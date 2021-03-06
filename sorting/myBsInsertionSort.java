import java.util.Arrays;

public class myBsInsertionSort{

    public static int[] sort(int[] a) {
        int N = a.length;

        int[] index = new int[N];
        for (int i = 0; i < N; i ++) index[i] = i;

        for (int i = 1; i < N; i ++) {
            int key = a[i];

            int low = 0, high = i - 1; // low ~ high is sorted.
            int mid = (low + high) / 2; // mid must be assigned value in any condition.
            while (low <= high) {
                mid = (low + high) / 2;
                // a[i] is the element that we want to search binariry.
                if (a[i] < a[mid])
                    high = mid - 1;
                else if (a[i] > a[mid])
                    low = mid + 1;
                else break;
            }

            // now find the a[i]'s exact place -- mid or mid + 1
            // 以k做循环变量的时候不要习惯性的把i写进去！
            if (a[low] == key) continue; // it means that the a[i]'s original place is exactly the right place.
            for (int k = i; k > mid ; --k) {
                a[k] = a[k - 1];
                index[k] = index[k - 1];
            }

            a[low] = key;

            //while (j >= 1 && key < a[j - 1]) {
                //a[j] = a[j - 1];
                //j --;
            //}
            //a[j] = key;
        }

        return index;
    }

    public static void main (String [] args) {
        int[] a = {3, 3, 2, 1, 5, 5, 6, 7, 4};
        int[] b = new int[9];
        for (int i = 0; i < 9; i ++) b[i] = a[i];
        //int[] index = {0, 1, 2, 3, 4, 5, 6, 7, 8};
        //int[] a = {1, 2, 3, 5, 6};
        int[] index = new int[9];
        index = myBsInsertionSort.sort(a);
        int N = a.length;
        StdOut.println();
        StdOut.println("To Analyze the sort algorithm:");
        StdOut.println();
        StdOut.println("original " + "sorted " + "index");
        StdOut.println();
        for (int i = 0; i < N; i ++) StdOut.println("   " + b[i] + "       " + a[i] + "      " + index[i]);

    }
}
            // the index `low` is where the key should be put in.
            // in most cases, we think that the mid place is the right place,
            // but if the element is bigger than any element in the array, the
            // mid only describe the last place which is not the right place
