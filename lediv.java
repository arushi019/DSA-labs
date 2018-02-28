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
class lediv{
    public static int gcd(int x,int y){
        int m=x;
        int n=y;
        while(m!=n){
            if (m>n)m=m-n;
            else n=n-m;
        }
        return m;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int prev=1;
            int flag=1;
            if (n==1){
                System.out.println(Reader.nextInt());
            }
            else{
            for (int i=0;i<n;i++){
                int temp=Reader.nextInt();
                if (i>0){
                    flag=gcd(temp,prev);
                    prev=flag;
                }
                else prev=temp;   
                //System.out.println(flag);
            }
            if (flag==1)System.out.println("-1");
            else System.out.println(flag);
            }
        }
    }
}