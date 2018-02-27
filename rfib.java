//Arushi Chauhan 
//2016019
//Sec-A Grp-2
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
public class rfib{
    public static long rfb(long n){
        if ((n==1)||(n==2)){
            return 1;
        }
        else{
            return rfb(n-1)+rfb(n-2);
        }
    }   
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        long n1;
        n1=Long.parseLong(Reader.next());
        long startTime=System.currentTimeMillis();
        
        System.out.print(rfb(n1)%2014);
        long endTime=System.currentTimeMillis();
        double TimeElapsed=(endTime-startTime)/1000.0;
        System.out.print(" "+TimeElapsed);
    }
}