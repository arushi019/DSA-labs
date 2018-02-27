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

public class mindiff{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n1,i,j;
        n1=Reader.nextInt();
        int[] a=new int[n1];
        int small;
        small=0;
        for (i=0;i<n1;i++){
            a[i]=Reader.nextInt();
            if (a[i]>small)small=a[i];
        }
        int diff;
        for (i=0;i<n1;i++){
            for (j=0;j<n1;j++){
                if (i!=j){
                    diff=a[i]>a[j]?a[i]-a[j]:a[j]-a[i];
                    if (diff<small){
                        small=diff;
                    }
                }
            }
        }
        System.out.println(small);
    }
}