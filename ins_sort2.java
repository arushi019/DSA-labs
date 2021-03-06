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
public class ins_sort2{
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int[] a=new int[100];
        int max;
        int i,j,key;
        max=Reader.nextInt();
        for (i=0;i<max;i++)
            a[i]=Reader.nextInt();
        for (i=0;i<max-1;i++){
            for (j=i+1;j>0;j--){
                if (a[j]<a[j-1]){
                    key=a[j];
                    a[j]=a[j-1];
                    a[j-1]=key;
                }
            }
        }
        for (i=0;i<max;i++)System.out.print(a[i]+" ");
    }
}