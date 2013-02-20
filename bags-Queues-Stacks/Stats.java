/*
 * Stats.java is a bag client that reads a sequence of real numbers from stand 
 * input and prints their mean and standard deviation.
 *
 */

public class Stats {

    public static void main (String [] args) {
        // read in numbers
        Bag<Double> numbers = new Bag<Double>();
        while (!StdIn.isEmpty()) {
            numbers.add(StdIn.readDouble());
        }
        int N = numbers.size();

        // compute sample mean
        double sum = 0.0;
        for (double x : numbers)
            sum += x;
        double mean = sum / N;

        // compute sample standard deviation
        sum = 0.0;
        for (double x : numbers) 
            sum += (x - mean) * (x - mean);
        double std = Math.sqrt(sum / (N - 1));

        // pay attention that the output should be ended by ctrl+d.
        // and it will output as like the follow patterns.
        StdOut.printf("Mean:    %.2f\n", mean);
        StdOut.printf("Std dev: %.2f\n", std);
    }
}
