/*
 * The Stack class represents a last-in-fist-out (LIFO) stack of generic items.
 * It supports the usual push and pop operations, along with methods for peeking
 * at the top item, testing if the stack is empty, and iterating through the
 * items in LIFO order.
 *
 * All stack operations exception iteration are constant time.
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Stack<Item> implements Iterable<Item> {
    private int N;      // size of the stack
    private Node first; // top of stack

    // help linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    // Create an empty stack.
    public Stack() {
        N = 0;
        first = null;
        assert check();
    }

    // Is the stack empty?
    public boolean isEmpty() {
        return first == null;
    }

    // Return the number of items in the stack
    public int size() {
        return N;
    }

    // Add the item to the stack
    // --->>> REMEMBER to add the item in the FIRST!!!
    public void push(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N ++;
        assert check();
    }

    /* Delete and return the item most recently added to the stack.
     * @throws java.util.NoSuchElementException if stack is empty.
     * --->>> REMEMBER to delete the item from the FIRST!!!
     */
    public Item pop() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        Item item = first.item;
        first = first.next;
        N --;

        /* remind yourself that whenever you operate the collection including bag,
         * queue, and stack and so on, remember to change the total amount N of
         * the connection when you add or delete the item in the collection.
         */

        assert check();
        return item;
    }

    /*
     * Return the item least recently added to the stac.
     * @throws java.util.NoSuchElementException if stack is empty.
     */
    public Item peek() {
        if (isEmpty())
            throw new NoSuchElementException("Queue underflow.");
        return first.item;
    }

    // Return string representation.
    public String toString() {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item + " ");
        return s.toString();
    }

    // check internal invariants
    private boolean check() {
        if (N == 0) {
            if (first != null) return false;
        }
        else if (N == 1) {
            if (first == null) return false;
            if (first.next != null) return false;
        }
        else {
            if (first.next == null) return false;

            // check internal consistency of instance variable N
            int numberOfNodes = 0;
            for (Node x = first; x != null; x = x.next)
                numberOfNodes ++;
            if (numberOfNodes != N) return false;
        }

        return true;
    }

    // Return an iterator that iterates over the items on the stack in LIFOorder
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // A test client
    public static void main (String [] args)
    {
        Stack<String> s = new Stack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}
