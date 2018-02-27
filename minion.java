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
public class minion{
    public static void main(String[] args) throws IOException{
        int N,t;
        int a[]=new int[100];
        Reader.init(System.in);
        N=Reader.nextInt();
        t=Reader.nextInt();
        int k=0;
        while(k<t){
            a[k]=Reader.nextInt();
            if ((N-a[k])!=0){
                for(int i=0;i<(N-a[k]);i++)
                    System.out.println(a[k]);
            }
            else System.out.println("-1");
            k++;
        }

    }
}