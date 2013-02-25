/*
 * A list implementation with a doubly linked list. The elements are stored
 * (and iterated over) in the same order that they are inserted.
 */

import java.util.ListIterator;
import java.util.NoSuchElementException;

public class DoublyLinkedList<Item> implements Iterable<Item>{

    private int N;    // number of elements on list
    private Node pre; // sentinel before first item
    private Node post;// sentinel  after  last item

    public DoublyLinkedList() {
        pre = new Node();
        post = new Node();
        pre.next = post;
        post.prev = pre;
    }

    // linked list node helper data type
    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    public boolean isEmpty() { return N == 0; }
    public int size() { return N; }

    // add the item to the list
    public void add(Item item) {
        Node last = post.prev;
        Node x = new Node();
        x.item = item;
        x.next = post;
        x.prev = last;
        post.prev = x;
        last.next = x;
        N ++;
    }

    public ListIterator<Item> iterator()  { return new DoublyLinkedListIterator(); }

    // assumes no calls to DoublyLinkedList.add() during iteration
    private class DoublyLinkedListIterator implements ListIterator<Item> {
        private Node current      = pre.next;  // the node that is returned by next()
        private Node lastAccessed = null;      // the last node to be returned by prev() or next()
                                               // reset to null upon intervening remove() or add()
        private int index = 0;

        public boolean hasNext()      { return index < N; }
        public boolean hasPrevious()  { return index > 0; }
        public int previousIndex()    { return index - 1; }
        public int nextIndex()        { return index;     }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            lastAccessed = current;
            Item item = current.item;
            current = current.next;
            index++;
            return item;
        }

        public Item previous() {
            if (!hasPrevious()) throw new NoSuchElementException();
            current = current.prev;
            index--;
            lastAccessed = current;
            return current.item;
        }

        // replace the item of the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void set(Item item) {
            if (lastAccessed == null) throw new IllegalStateException();
            lastAccessed.item = item;
        }

        // remove the element that was last accessed by next() or previous()
        // condition: no calls to remove() or add() after last call to next() or previous()
        public void remove() {
            if (lastAccessed == null) throw new IllegalStateException();
            Node x = lastAccessed.prev;
            Node y = lastAccessed.next;
            x.next = y;
            y.prev = x;
            N--;
            index--;
            lastAccessed = null;
        }

        // add element to list
        public void add(Item item) {
            Node x = current.prev;
            Node y = new Node();
            Node z = current;
            y.item = item;
            x.next = y;
            y.next = z;
            z.prev = y;
            y.prev = x;
            N++;
            index++;
            lastAccessed = null;
        }

    }



    // a test client
    public static void main(String[] args) {
        int N  = Integer.parseInt(args[0]);

        // add elements 1, ..., N
        DoublyLinkedList<Integer> list = new DoublyLinkedList<Integer>();
        for (int i = 0; i < N; i++)
            list.add((int) (100 * Math.random()));

        // try out the iterator
        for (Integer x : list)
            StdOut.print(x + " ");
        StdOut.println();

        ListIterator<Integer> iterator = list.iterator();

        // go forwards
        while (iterator.hasNext()) {
            int x = iterator.next();
            iterator.set(x + 1);
        }

        // print contents of list
        for (Integer x : list)
            StdOut.print(x + " ");
        StdOut.println();

        // go backwards
        while (iterator.hasPrevious()) {
            int x = iterator.previous();
            iterator.set(x + x + x);
        }

        // print contents of list
        for (Integer x : list)
            StdOut.print(x + " ");
        StdOut.println();

        // remove all even elements
        while (iterator.hasNext()) {
            int x = iterator.next();
            if (x % 2 == 0) iterator.remove();
        }

        // print contents of list
        for (Integer x : list)
            StdOut.print(x + " ");
        StdOut.println();

    }
}
