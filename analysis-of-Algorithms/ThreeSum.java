public class ThreeSum {
    // print distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static void printAll(int[] a) {
        int N = a.length;
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    if (a[i] + a[j] + a[k] == 0)
                        StdOut.println(a[i] + " " + a[j] + " " + a[k]);
                }
            }
        }
    }

    // return number of distinct triples (i, j, k) such that a[i] + a[j] + a[k] = 0
    public static int count(int[] a) {
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = i + 1; j < N; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    if (a[i] + a[j] + a[k] == 0)
                        cnt ++;
                }
            }
        }
        return cnt;
    }

    public static void main (String [] args) {
        int[] a = In.readInts(args[0]);

        Stopwatch timer = new Stopwatch();
        int cnt = count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(cnt);
    }
}
