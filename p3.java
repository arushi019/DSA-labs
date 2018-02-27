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
class p3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        BigInteger p1=BigInteger.valueOf(Integer.parseInt(args[0]));
        int i1=p1.intValue();
        int s1=(int)Math.sqrt(i1);
        while(p1.equals(BigInteger.ONE)==false){
            for (int i=2;i<s1;i++){
                if (p1.mod(BigInteger.valueOf(i))==BigInteger.ZERO){
                    p1=p1.divide(BigInteger.valueOf(i));
                    System.out.println(i);
                    break;
                }
            }
        }


    }
}