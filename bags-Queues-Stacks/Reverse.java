/*
 * Reverse.java is a stack client that reads a sequence of integers from
 * standard input and prints them in reverse order.
 *
 */

public class Reverse {

    public static void main (String [] args) {
        Stack<Integer> stack = new Stack<Integer>();
        while (!StdIn.isEmpty())
            stack.push(StdIn.readInt());

        for (int i : stack)
            StdOut.println(i);
    }
}
