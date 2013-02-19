/*
 * DoublingTest.java generates a sequence of random input arrays, doubling the 
 * arraysize at each step, and prints the running times of ThreeSum.count() for 
 * each input size.
 *
 */
public class DoublingTest {
    
    // time ThreeSum.count() for N random 6-digit ints
    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i ++) {
            a[i] = StdRamdom.unifom(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        return timer.elapsedTime();
    }

    public static void main (String [] args) {
        for (int N = 250; true; N += N) {
            double time = timeTrial(N);
            StdOut.printf("%7d %5.1f\n", N, time);
        }
    }
}
