/*
 * Sort the files in a given directory by filename.
 */
/*
 * The reasonthat the Insertion.sort() Algorithms can sort all the data type is
 * that we implements Comparable<Item> to make a callbacks.
 */

import java.io.File;

public class FileSorter {

    public static void main (String [] args)
    {
        File directory = new File(args[0]);
        File[] files = directory.listFiles();
        Insertion.sort(files);
        for (int i = 0; i < files.length; i++)
            StdOut.println(files[i].getName());
    }
}

// Below is a eg to describe how to implement Comparable
public class Date implements Comparable<Date> {

    private final int day, month, year;

    public Date(int d, int m, int y) {
        day = d;
        month = m;
        year = y;
    }

    public int compareTo(Date that) {
        if (this.year < that.year) return -1;
        if (this.year > that.year) return +1;
        if (this.month < that.month) return -1;
        if (this.month > that.month) return +1;
        if (this.day < that.day) return -1;
        if (this.day > that.day) return +1;
        return 0;
    }
}

/*
 * Belows are the details API java supports.
 */
