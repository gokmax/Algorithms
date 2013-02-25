/*
 *  Wget.java can pull the content of the website file to local computer.
 * 
 *  eg: when you type "java Wget http://gokmax.com"
 *  it will pull the index page of the gokmax.com to the local computer
 *  by using it powerful in and out object.
 *  And it is surprising that the code is so simple to write and understand.
 *
 */

public class Wget {

    public static void main (String[] args) {

        //read in data from URL
        String url = args[0];
        In in = new In(url);
        String data = in.readAll();

        // write data to a file
        String filename = url.substring(url.lastIndexOf("/") + 1);
        Out out = new Out(filename);
        out.println(data);
        out.close();
    }
}
