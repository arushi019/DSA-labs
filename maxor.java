import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
import java.awt.Point;
import java.text.DecimalFormat;
//Q3 refresher module-Arushi Chauhan-2016019-sec-a
 
 
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
    static long nextLong() throws IOException {
        return Long.parseLong( next() );
    }
}
class maxor{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int[] arr=new int[n];
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
            }
            int ct=0;
            for (int i=0;i<n;i++){
                for (int j=i+1;j<n;j++){
                    int k=arr[i]|arr[j];
                    int max=arr[i]-((arr[i]-arr[j])&((arr[i]-arr[j])>>(Integer.SIZE*CHAR_BIT-1)));
                    if (k<=max)ct++;
                }
            }
            System.out.println(ct);
        }
    }
}