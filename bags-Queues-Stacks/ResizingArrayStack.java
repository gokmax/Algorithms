/*
 * Stack implementation with a resizing array.
 */

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ResizingArrayStack<Item> implements Iterable<Item> {
    private Item[] a;  // array of items
    private int N;     // number of elements on stack

    // create an empty stack
    public ResizingArrayStack() {
        a = (Item[]) new Object[2];
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= N;
        Item[] temp = (Item[]) new Object[capacity];
        for (int i = 0; i < N; i ++) 
            temp[i] = a[i];
        a = temp;
    }

    // push a new item onto the stack
    public void push(Item item) {
        if (N == a.length) resize(2 * a.length); // double size of array if necessary
        a[N++] = item;
    }

    // delete and return the item most recently added
    public Item pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow error");
        }
        Item item = a[N-1];
        a[N-1] = null; // to avoid loitering
        N --;
        // shrink size of array if necessary
        if (N > 0 && N == a.length / 4) resize(a.length / 2);
        return item;
    }

    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // an iterator, doesn't implement remove() since it's optional
    private class ReverseArrayIterator implements Iterator<Item> {
        private int i;

        public ReverseArrayIterator() {
            i = N;
        }

        public boolean hasNext() {
            return i > 0;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return a[--i];
        }
    }

    /*
     * Test routine.
     */
    public static void main (String [] args)
    {
        ResizingArrayStack<String> s = new ResizingArrayStack<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString();
            if (!item.equals("-")) s.push(item);
            else if (!s.isEmpty()) StdOut.print(s.pop() + " ");
        }
        StdOut.println("(" + s.size() + " left on stack)");
    }
}


















