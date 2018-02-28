import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;

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
class leperm{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int[] a;
        int n;
        int inv,linv,i,j;
        while(t-->0){
            n=Reader.nextInt();
            i=0;
            a=new int[n];
            inv=0;
            linv=0;
            int prev=0;
            while(i<n){
                a[i]=Reader.nextInt();
                if (i>0){
                    //System.out.println(prev+" "+a[i]);
                    linv=prev>a[i]?linv+1:linv;
                }
                prev=a[i];
                i++;
            }
            i=0;
            while(i<n){
                j=i+1;
                while(j<n){
                    inv=a[i]>a[j]?inv+1:inv;
                    j++;
                }
                i++;
            }
            //System.out.println(inv+" "+linv);
            if (inv==linv)System.out.println("YES");
            else System.out.println("NO");
        }
    }
}