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
class playfit{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int t=Reader.nextInt();
        while(t-->0){
            int n=Reader.nextInt();
            int[] arr=new int[n];
            int[] min=new int[n];
            int mini=0;
            for (int i=0;i<n;i++){
                arr[i]=Reader.nextInt();
                if (i==0){
                    min[0]=arr[i];
                    mini=arr[i];
                }
                else{
                    min[i]=mini;
                    if (arr[i]<mini)mini=arr[i];
                }
            }
            int diff=0;
            for (int i=0;i<n;i++){
                //System.out.print(min[i]+" ");
                if (arr[i]-min[i]>diff)diff=arr[i]-min[i];
            }
            if (diff==0)System.out.println("UNFIT");
            else System.out.println(diff);
        }
    }
}