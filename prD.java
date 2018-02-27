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
class prD{
    public static long lcm(long x,long y){
        long x1=x;
        long y1=y;
        while(x1!=y1){
            if (x1>y1)x1=x1-y1;
            else y1=y1-x1;
        }
        long pro=x*y;
        pro=pro/x1;
        return pro;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        long n=Reader.nextLong();
        long a=Reader.nextLong();
        long b=Reader.nextLong();
        long c=Reader.nextLong();
        long p1=lcm(a,b);
        long p2=lcm(b,c);
        long p3=lcm(a,c);
        long p4=lcm(p1,c);
        long sum=n/a+n/b+n/c-n/p1-n/p2-n/p3+n/p4;
        System.out.println(sum);
    }
}