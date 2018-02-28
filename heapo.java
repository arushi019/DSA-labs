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
class heapo{
    public static void ins(int v,int[] a,int n){
        a[n]=v;
        int it2=n;
        int it=(n-1)/2;
        while(it>=0){
            if (a[it2]<a[it]){
                int temp=a[it];
                a[it]=a[it2];
                a[it2]=temp;
                it2=it;
                it=(it-1)/2;
            }
            else break;
        }
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] a=new int[n+5];
        int i=0;
        while(i<n){
            a[i]=Reader.nextInt();
            i++;
        }
        int v=Reader.nextInt();
        ins(v,a,n);
        i=0;
        while(i<n+1){
            System.out.print(a[i]+" ");
            i++;
        }
    }
}