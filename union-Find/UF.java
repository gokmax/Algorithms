/*
 * the complete version of UNION FIND.
 * 2013.02.16
    
    在Union-Find 中，输入p，q两个数，如果说p与q已经connected，那么可以ignore然后continue，如果说p，q没有connected，输出到屏幕。
    此过程可以用实验室用网线实现电脑联网来理解。若某A，B电脑没有相连，则需要网线来连接A，B，这个时候就可以输出AB来告诉用户需要
    用网线来连接A，B。
   
     再者，如果说要询问实验室电脑是否两两相连，那么可以通过components的数量count来看出 。
     这是因为，如果说所有的点都属于同一个并查集，那么并查集的数量就只有一个，也就是说，属于同一个并查集的任意两个element
     都是connected的。

 */

public class UF {
    private int[] id;  // id[i] = parent of i
    private int[] sz;  // sz[i] = number of objects in subtree roots at i
    private int count; // number of components

    /*
     * Create an empty union find data structure with N isolated sets.
     * @throws java.lang.IllegalArgumentException if N < 0
     */
    public UF(int N) {
        if (N < 0) throw new IllegalArgumentException();
        count = N;
        id = new int[N];
        sz = new int[N];
        for (int i = 0; i < N; i ++) {
            id[i] = i;
            sz[i] = i;
        }
    }

    /*
     * Return the id of component corresponding to object p.
     * @throws java.lang.IndexOutOfBoundsException unless 0 <= p < N
     */
    public int find(int p) {
        if (p < 0 || p >= id.length) throw new IndexOutOfBoundsException();
        while (p != id[p])
            p = id[p];
        return p;
    }

    // Return the number of disjoint sets.
    public int count() {
        return count;
    }

    /*
     * Are objects p and q in the same set?
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p, q < N
     */
    public boolean connected(int p, int q) {
        if (p < 0 || p >= id.length || q < 0 || q >= id.length)
            throw new IndexOutOfBoundsException();
        return find(p) == find(q);
    }

    /*
     * Replace sets containing p and q with their union.
     * @throws java.lang.IndexOutOfBoundsException unless both 0 <= p, q < N
     */
    public void union(int p, int q) {
        if (p < 0 || p >= id.length || q < 0 || q >= id.length)
            throw new IndexOutOfBoundsException();
        int i = find(p);
        int j = find(q);
        if (i == j) return;

        // make smaller root point to larger one
        if (sz[i] < sz[j]) {
            id[i] = j;
            sz[j] += sz[i];
        }
        else {
            id[j] = i;
            sz[i] += sz[j];
        }
        count --;
    }

    public static void main(String[] args) {
        int N = StdIn.readInt();
        UF uf = new UF(N);

        // read in a sequence of pairs of integers (each in the range 0 to N-1).
        // call find() for each pair: If the members of the pair are not already
        // call union() and print the pair.
        while (!StdIn.isEmpty()) {
            int p = StdIn.readInt();
            int q = StdIn.readInt();
            if (uf.connected(p, q)) continue;
            uf.union(p, q);
            StdOut.println(p + " " + q);
        }
        StdOut.println(uf.count() + " components");
    }
}
