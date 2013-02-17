/*
 * QUICK UNION specifies by using a tree structure, each node has their father
 * except the root. It is easy to see that if two number(node) have the same
 * root, they are connected to each other. And when we union two number p and q,
 * we can just let p's parent become q. id[p] = q;
 * So UNION costs LgN and when we find a specific number it appears to cost LgN
 * time.
 * UNION -> LgN | FIND -> LgN
 */

public class QuickUnionUF {
    private int[] id; // id[i] = parent of i
    private int count; // number of components

    // instantiate N isolated components 0 through N-1
    public QuickUnionUF(int N) {
        id = new int[N];
        count = N;
        for (int i = 0; i < N; i ++)
            id[i] = i;
    }

    // return number of connected components
    public int count() {
        return count;
    }

    // return root of components corresponding to element p
    public int find(int p) {
        while (p != id[p]) p = id[p];
        return p;
    }

    // are elements p and q in the same component?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // merge components containing p and q
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        id[i] = j; // j's parent becomes id[i], in other words, i and j now have the same ancestor
        count --; // merge successfully and therefore the count decrease by 1
    }

    public static void main (String [] args)
    {
        int N = StdIn.readInt();
        QuickUnionUF uf = new QuickUnionUF(N);
        // read in a sequence of pairs of integers (each in the range 0 to N-1),
        // call find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty())  {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
