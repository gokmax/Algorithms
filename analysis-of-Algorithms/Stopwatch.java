/*
 * Stopwatch.java is a datatype that measures the elapsed running time of a program
 *
 */
public class Stopwatch {

    private final long start;

    // Create a stopwatch object.
    public Stopwatch() {
        start = System.currentTimeMillis();
    }

    // Return elapsed time (in seconds) since this object was created.
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}
