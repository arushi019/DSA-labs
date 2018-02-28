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
class eptree{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        BigInteger i1=BigInteger.valueOf(1000000005);
        BigInteger i2=BigInteger.valueOf(1000000007);
        BigInteger i3=BigInteger.valueOf(1000000009);
        while(t-->0){
            BigInteger n=BigInteger.valueOf(Reader.nextLong());
            BigInteger p=n.multiply(n.subtract(BigInteger.ONE));
            BigInteger q=n.multiply(BigInteger.valueOf(4));
            q=q.subtract(BigInteger.valueOf(6));
            BigInteger gc=p.gcd(q);
            if (gc!=BigInteger.ONE){
                p=p.divide(gc);
                q=q.divide(gc);
            }
            BigInteger a1=p.mod(i2);
            BigInteger a2=p.mod(i3);
            BigInteger b1=q.modPow(i1,i2);
            BigInteger b2=q.modPow(i2,i3);
            int t1=a1.multiply(b1).mod(i2).intValue();
            int t2=a2.multiply(b2).mod(i3).intValue();

            //BigInteger temp=p.divide(q);
            //BigInteger t1=temp.mod(BigInteger.valueOf(1000000007));
            //BigInteger t2=temp.mod(BigInteger.valueOf(1000000009));
            System.out.println(t1+" "+t2);

        }
    }
}