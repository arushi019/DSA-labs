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
class lcpesy{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int[] a1=new int[65];
            int[] a2=new int[65];
            String s1=Reader.next();
            String s2=Reader.next();
            for (int i=0;i<s1.length();i++){
                int temp=(int)s1.charAt(i);
                if ((temp>=65)&&(temp<=90))a1[temp-65]++;
                else if ((temp>=48)&&(temp<=57))a1[temp+4]++;
                else a1[temp-71]++;
            }
            for (int i=0;i<s2.length();i++){
                int temp=(int)s2.charAt(i);
                if ((temp>=65)&&(temp<=90))a2[temp-65]++;
                else if ((temp>=48)&&(temp<=57))a2[temp+4]++;
                else a2[temp-71]++;
            }
            int sum=0;
            for (int i=0;i<65;i++){
                //System.out.println(a1[i]+" "+a2[i]);
                sum+=a1[i]<a2[i]?a1[i]:a2[i];
            }
            System.out.println(sum);
        }
    }
}