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
public class bin_srch{
    public static int bsr(int a[],int key,int high,int low){
        mid=(high+low)/2;
        if (a[mid]==key)return mid;
        else{
            if (a[mid]>key)return bsr(a,key,mid-1,low);
            else return bsr(a,key,high,mid+1);
        }
    }
    public static void main(String[] args){
        int[] a1=new int[5];
        a1[5]={1,2,3,4,5};
        System.out.print(bsr(a1,2,4,0));
    }
}