import java.util.Arrays;

public class ThreeSumFast {
    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        Array.sort(a);
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                int k = Array.binarySearch(a, -(a[i] + a[j]));
                if (k > j) StdOut.println(a[i] + " " + a[j] + " " + a[k]);
            }
        }
    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int N = a.length;
        Array.sort(a);
        int cnt = 0
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                int k = Array.binarySearch(a, -(a[i] + a[j]));
                if (k > j) cnt ++;
            }
        }
        return cnt;
    }

    public static void main (String [] args) {
        int[] a = In.readInts(args[0]);
        int cnt = count(a);
        StdOut.println(cnt);
    }
}
