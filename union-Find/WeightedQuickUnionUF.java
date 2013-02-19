/*
 * WEIGHTED QUICK UNION
 * improve the algorithm by balance the tree.
 * use an sz[] array to record the number of objects in each subtree,
 * when merge two subtree, let the shorter tree's root become the child of the
 * higher one.
 *
 */

/* Understanding from the book:
 * Weighted quick-union. Rather than arbitrarily connecting the second tree to the first for union() in the quick-union algorithm, we keep track of the size of each tree and always connect the smaller tree to the larger. Program WeightedQuickUnionUF.java implements this approach.
 *
 */

public class WeightedQuickUnionUF {
    private int[] id;  // id[i] = parent of i
    private int[] sz;  // sz[i] = number of objects in subtree rooted at i
    private int count; //number of components

    // Create an empty union find data structure with N isolated sets
    public WeightedQuickUnionUF(int N) {
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i ++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    // Return component identifier for component containing p
    public int find(int p) {
        while (p != id[p])
            p = id[p];
        return p;
    }

    // Are objects p and q in the same set?
    public boolean connected(int p, int q) {
        return find(p) == find(q);
    }

    // Replace sets containing p and q with their union.
    public void union(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to large one
        if (sz[i] < sz[j]) {
            id[i] = j; // j becomes i's parent and therefore becomes the new root of i and j
            sz[j] += sz[i]; // update the size of j
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        WeightedQuickUnionUF uf = new WeightedQuickUnionUF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1)
        // call find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " component");
    }
}
