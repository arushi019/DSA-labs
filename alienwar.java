import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


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
public class alienwar{
    public static void main(String[] args) throws IOException{
        int t,a,b,c,d;
        long k1,k2;
        Reader.init(System.in);
        t=Reader.nextInt();
        while(t-->0){
            a=Reader.nextInt();
            b=Reader.nextInt();
            c=Reader.nextInt();
            d=Reader.nextInt();
            k1=a<<b+1;
            k2=c<<d+1;
            if (k1>k2)System.out.print("Alien");
            else System.out.print("Warrior");
            System.out.println(k1+"   "+k2);
            if (t!=0)System.out.println();
        }
    }
}