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
class nice{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        int[] a;
        int[] b;
        while(t-->0){
            n=Reader.nextInt();
            a=new int[n];
            int i=0;
            while(i<n){
                a[i]=Reader.nextInt();
                i++;
            }
            Arrays.sort(a);
            if (a[1]-a[0]!=1)System.out.println(a[0]);
            else if (a[n-1]-a[n-2]!=1)System.out.println(a[n-1]);
            else{
                i=0;
                while(i<n-1){
                    if (a[i]==a[i+1]){System.out.println(a[i]);break;}
                    i++;
                }
            }
        }
    }
}