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
}
class explore4{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int x1,y1,x2,y2;
        x1=Reader.nextInt();
        y1=Reader.nextInt();
        x2=Reader.nextInt();
        y2=Reader.nextInt();
        long t=(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2);
        int r=Reader.nextInt();
        long r2=(long)r*r;
        if (t<=r2)System.out.println("Unlimited Hoyenga");
        else System.out.println("Nahi Hoyenga");
    }
}