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
class bintree{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        for (int i=0;i<n;i++){
            int x=Reader.nextInt();
            int y=Reader.nextInt();
            int p1=x;
            int p2=y;
            int c1=0;
            int c2=0;
            int c3=0;
            HashSet<Integer> hs=new HashSet<Integer>();
            hs.add(p1);
            while(p1!=1){
                p1=p1/2;
                c1++;
                hs.add(p1);
            }      
            //System.out.println(hs);
            int flag=-1;
            while(p2!=1){
                if ((hs.contains(p2))&&(flag==-1)){
                    flag=p2;
                }
                p2=p2/2;
                c2++;
                //System.out.println(p2+" "+flag);
            }
            while(flag>1){
                flag=flag/2;
                c3++;
                //System.out.println(flag);
            }
            System.out.println(c1+c2-2*c3);

        }
    }
}