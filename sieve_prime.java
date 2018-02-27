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
public class sieve_prime{
    public static void main(String[] args)throws IOException{
        int[] a=new int[1000000];
        int n,i,j;
        Reader.init(System.in);
        n=Reader.nextInt();
        a[0]=-1;
        a[1]=-1;
        a[2]=0;
        for (i=2;i<n;i++){
            if (a[i]!=-1)
            {for (j=i;j<n;j=j*i){
                a[j]=-1;
            }}
        }
        for (i=0;i<n;i++)System.out.println(a[i]);
    }
}