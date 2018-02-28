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
public class caravan{
    public static void main(String[] args) throws IOException{
        int t,n;
        Reader.init(System.in);
        int i,ct;
        int a1[]=new int[10000];
        int a2[]=new int[10000];
        t=Reader.nextInt();
        while(t-->0){
            n=Reader.nextInt();
            i=0;
            while(i<n){
                a1[i]=Reader.nextInt();
                i++;
            }
            i=0;
            while(i<(n-1)){
                if (a1[i]>=a1[i+1]){
                    a2[i]=a1[i];
                    a2[i+1]=a2[i+1];
                }
                else{
                    a2[i]=a1[i];
                    a2[i+1]=a1[i];
                } 
                i++;
            }
            i=0;
            ct=0;
            while(i<n){
                if (a1[i]==a2[i])ct++;
            }
            System.out.println(ct);
        }
    }
}