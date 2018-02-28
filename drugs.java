import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

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
public class drugs{
    public static void main(String[] args)throws IOException{
        int n;
        long max=0,cad;
        Reader.init(System.in);
        n=Reader.nextInt();
        int[] a=new int[n];
        int i=0;
        for (i=0;i<n;i++){a[i]=Reader.nextInt();}//System.out.print(a[i]);}
        Arrays.sort(a);
        //for (i=0;i<n;i++)System.out.print(a[i]+" ");
        for(i=0;i<n;i++){
            cad=a[i]*(n-i);
            //System.out.print(a[i]+" ");
            if (cad>max){
                max=cad;
            }
        }
        System.out.print(max);
}
}