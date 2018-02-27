import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;

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
class pop{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        int n;
        int[] a;
        while(t-->0){
            n=Reader.nextInt();
            a=new int[2*n];
            int i=0;
            while(i<2*n){
                a[i]=Reader.nextInt();
                i++;
            }
            Arrays.sort(a);
            /*i=1;
            while(i<2*n-2){
                int temp=a[i];
                a[i]=a[i+1];
                a[i+1]=temp;
                i+=2;
            }*/
            System.out.println(a[2*n-n/2-1]);
            i=2*n-n/2-1;
            int ct=0;
            while(i<2*n-1){
                int temp=a[i];
                a[i]=a[n+2*ct];
                a[n+2*ct]=temp;
                ct++;
                i++;
            }
            i=0;
            while(i<2*n){
                System.out.print(a[i]+" ");
                i++;
            }
        }
    }
}