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
public class byte{
    public static int rec_bar(int[] a,int ptr,int sum,int m){
        if (sum+a[ptr]==m)return -1;
        else{
            if (sum+a[ptr]<m){
                return rec_bar(a,ptr+1,sum+a[ptr],m);
            }
            else if (sum+a[ptr]>m){
                return;
            }
        }

        }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n,m;
        int[] a;
        int i;
        while(t-->0){
            n=Reader.nextInt();
            m=Reader.nextInt();
            a=new int[n];
            for (i=0;i<n;i++){
                a[i]=Reader.nextInt();

            }
            Arrays.sort(a);
            int r=rec_bar(a,0,0,m);
            System.out.println(r);
        }
    }
}