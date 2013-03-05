/*
 * need more condition.
 * be careful.
 */

import java.util.Arrays;

public class Graph {

    public static boolean sort(int[] a) {

        int len = a.length;
        int originalSum = 0;
        for (int i = 0; i < len - 1; i ++) {
            if (a[i] < 0) return false;
            if (a[i] < a[i + 1]) return false;
            originalSum += a[i];
        }
        if (a[len - 1] < 0) return false;
        originalSum += a[len - 1];
        if (originalSum % 2 != 0) return false;
        // initialized graph judgement ends here.

        int d1 = a[0];
        int newSum = 0;
        for (int i = 1; i <= d1; i ++) {
            a[i] --;
            if (a[i] < 0) return false;
            newSum += a[i];
        }
        for (int i = d1 + 1; i < len; i ++)
            newSum += a[i];
        if (newSum % 2 != 0) return false;

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
