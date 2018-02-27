import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.io.*;
import java.util.*;
import java.math.BigDecimal;
import java.lang.*;
 

 
 
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
class snake4{
    public static int bigsearch(int[] len,int q){
        int low=0;
        int high=len.length-1;
        int mid=(low+high)/2;
        int pos=mid;
        while(low!=high){
            mid=(low+high)/2;
            if (len[mid]==q){
                pos=mid;
                break;
            }
            else if (len[mid]>q){
                high=mid-1;
                pos=mid;
            }
            else if (len[mid]<q){
                low=mid+1;
                pos=mid;
            }
        }
        return pos;
    }
    public static void main(String[] args)throws IOException{
        Reader.init(System.in);
        int n=Reader.nextInt();
        int[] len=new int[n];
        for (int i=0;i<n;i++)len[i]=Reader.nextInt();
        int q=Reader.nextInt();
        System.out.println(bigsearch(len,q));
    }
}