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
public class defe{
    public static void main(String[] args) throws IOException{
        int t,n;
        int a[]=new int[30];
        Reader.init(System.in);
        t=Reader.nextInt();
        int i;
        int sum;
        while(t-->0){
            sum=0;
            i=0;
            n=Reader.nextInt();
        while(i<n){
            a[i]=Reader.nextInt();
            sum+=(int)a[i]/3;
            i++;
        }
        System.out.println(sum);
    }
    }
}