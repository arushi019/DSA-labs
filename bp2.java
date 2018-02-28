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
 //Q1 refresher module-Arushi Chauhan-2016019-sec-a

 
 
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
class bp2{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        String s1=Reader.next();
        String s2=new String();
        char flag=s1.charAt(0);
        int ct=1;
        for (int i=1;i<s1.length();i++){
            if (s1.charAt(i)!=flag){
                s2=s2+flag+ct;
                ct=1;
                flag=s1.charAt(i);
            }
            else ct++;
        }
        s2=s2+flag+ct;
        System.out.println(s2);
    }
}