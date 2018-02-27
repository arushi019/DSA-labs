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
class prC1{
    public static HashMap<Integer,Integer> hs;
    public static BigInteger cons;
    public static BigInteger cons2;
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        BigInteger cons=BigInteger.valueOf(2);
        while(t-->0){
            long n=Reader.nextLong();
            BigInteger t1=cons.modPow(BigInteger.valueOf(n-1),BigInteger.valueOf(1000000007));
            BigInteger c1=BigInteger.valueOf(n*n-n+2);
            t1=t1.multiply(c1);
            t1=t1.subtract(BigInteger.ONE);
            t1=t1.mod(BigInteger.valueOf(1000000007));
            System.out.println(t1.intValue());
        }
    }

}