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
class explore3{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] arr=new int[n];
        int[] sc=new int[n];
        int[] run=new int[8];
        int ct=0;
        int high=0;
        boolean cap=true;
        for (int i=0;i<n;i++)arr[i]=Reader.nextInt();
        for (int i=0;i<n;i++){
            sc[i]=Reader.nextInt();
            if (sc[i]>=(arr[i]/3))ct++;
            high+=sc[i];
        }
        for (int i=0;i<8;i++){
            run[i]=Reader.nextInt();
            if (run[i]>high)cap=false;
        }
        boolean val=false;
        if (ct>=(n*7)/10)val=true;
        //System.out.println(ct+" "+val+" "+cap);
        if ((val)&&(cap))System.out.println("VIRAT KOHLI IS CHAMPION");
        else System.out.println("RCB TRY AGAIN IN NEXT IPL");
    }
}