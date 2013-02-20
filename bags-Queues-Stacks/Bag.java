/*
 * The Bag class represents a bag (or muliset) of generic items.
 * It support insertion and iterating over the items in arbitrary order.
 * The add, isEmpty, and size operation take constant time.
 * Iteration takes time proportional to the number of items.
 *
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Bag<Item> implements Iterable<Item> {
    private int N;      // number of elements in bag
    private Node first; // beginnin of bag

    // helper linked list class
    private class Node {
        private Item item;
        private Node next;
    }

    // Create an empty bag.
    public Bag() {
        N = 0;
        first = null;
        assert check();
    }

    // Is the Bag empty?
    public boolean isEmpty() {
        return first == null;
    }

    // Return the number of items in the bag.
    public int size() {
        return N;
    }

    // Add the item to the bag.
    public void add(Item item) {
        Node oldfirst = first;
        first = new Node();
        first.item = item;
        first.next = oldfirst;
        N++;
        assert check();
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
        }

        // check internal consistency of instance variable N
        int numberOfNodes = 0;
        for (Node x = first; x != null; x = x.next)
            numberOfNodes ++;
        if (numberOfNodes != N) return false;

        return true;
    }

    // Return an iterator that iterates over the items in the bag.
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
    public static void main (String [] args) {
        Bag<String> bag = new Bag<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            bag.add(item);
        }

        StdOut.println("size of bag = " + bag.size());
        for (String s : bag) {
            StdOut.println(s);
        }
    }
}
