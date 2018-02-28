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
class like{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int l=Reader.nextInt();
            int d=Reader.nextInt();
            int s=Reader.nextInt();
            int c=Reader.nextInt();
            int i=1;
            BigInteger sum=BigInteger.valueOf(s);
            BigInteger cc=BigInteger.valueOf(c+1);
            cc=cc.pow(d-1);
            sum=sum.multiply(cc);
            BigInteger ll=BigInteger.valueOf(l);
            int kt=sum.compareTo(ll);
            if (kt==-1)System.out.println("DEAD AND ROTTING");
            else System.out.println("ALIVE AND KICKING");
        }
    }
}