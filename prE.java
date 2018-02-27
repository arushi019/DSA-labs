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
class prE{
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] arr=new int[n];
        int[] nexthigh=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=Reader.nextInt();
        }
        int hindex=n-1;
        for (int i=n-1;i>=0;i--){
            if (arr[i]>arr[hindex])hindex=i;
            nexthigh[i]=hindex;
        }
        long sum=0;
        for (int i=0;i<n;i++){
            if (nexthigh[i]==i)continue;
            else{
                int j=i;
                while(nexthigh[j]!=j)j=nexthigh[j];
                sum+=(long)arr[j]-(long)arr[i];
                //System.out.println(arr[j]+" "+arr[i]);
            }
        }
        System.out.println(sum);
    }
}