import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;

/** Class for buffered reading int and double values */
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
public class linked_list{
    public static void main(String[] args){
        LinkedList<String> ll=new LinkedList<String>();
        ll.add("A");
        ll.add("R");
        ll.add("U");
        ll.add("S");
        ll.add("H");
        ll.add("I");
        ll.addLast("H");
        ll.addLast("S");
        ll.addFirst("S");
        ll.addFirst("H");
        /*ll.remove("A");
        ll.remove("R");
        ll.remove("U");
        ll.remove("I");*/
        ll.add(2,"201");
        String val=ll.get(2);
        ll.add(9,"183");
        String val2=ll.get(9);
        ll.set(2,"98");
        ll.set(9,"98");
        System.out.println("val= "+val);
        System.out.println("val2= "+val2);
        System.out.println("Linked list now: "+ll);
    }
}