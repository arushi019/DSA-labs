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
public class prime2{
    public static void main(String[] args)throws IOException{
        int i,n,flag=-1;
        Reader.init(System.in);
        n=Reader.nextInt();
        for (i=2;i<n;i++){
            flag=-1;
            for (int j=2;j<=Math.sqrt(i);j++){
                if (i%j==0){
                    flag=0;
                    break;
                }
            }
            if (flag==-1)System.out.println(i);
        }
    }
}