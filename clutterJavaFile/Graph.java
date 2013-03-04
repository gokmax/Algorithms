import java.util.Arrays;

public class Graph {

    public static boolean sort(int[] a) {

        int len = a.length;
        int sum1 = 0;
        for (int i = 0; i < len - 1; i ++) {
            if (a[i] < 0) return false;
            if (a[i] < a[i + 1]) return false;
            sum1 += a[i];
        }
        if (a[len - 1] < 0) return false;
        sum1 += a[len - 1];
        if (sum1 % 2 != 0) return false;
        // initialized graph judgement ends here.

        int d1 = a[0];
        int sum2 = 0;
        for (int i = 1; i <= d1; i ++) {
            a[i] --;
            if (a[i] < 0) return false;
            sum2 += a[i];
        }
        for (int i = d1 + 1; i < len; i ++)
            sum2 += a[i];
        if (sum2 % 2 != 0) return false;

        return true;
    }

    public static void main (String [] args) {
        int[] a = {5, 5, 4, 3, 2, 1};
        StdOut.println(Graph.sort(a));
    }
}


/*
 *
 *
 *
 *
 */
