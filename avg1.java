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
public class avg1{
    public static void main(String[] args) throws IOException{
        int n;
        int a[]=new int[1000];
        float avgs;
        int t,ct;
        long sum;
        sum=0;
        ct=0;
        Reader.init(System.in);
        n=Reader.nextInt();
        for(t=0;t<n;t++){
            a[t]=Reader.nextInt();
            sum+=a[t];
        }   
        avgs=sum/n;
        for (t=0;t<n;t++){
            if (avgs<a[t])ct++;
         }
        //System.out.println(avgs);
        System.out.print(ct);
        }
}
